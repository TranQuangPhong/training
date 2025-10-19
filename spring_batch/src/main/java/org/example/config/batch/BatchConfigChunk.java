package org.example.config.batch;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.example.exception.GracefulRollbackException;
import org.example.model.dto.Order;
import org.example.model.entity.ItemEntity;
import org.example.repo.ItemRepo;
import org.springframework.batch.core.*;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.batch.item.validator.SpringValidator;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

//@Configuration //Enable to apply chunk-oriented
public class BatchConfigChunk {

    @Autowired
    ItemRepo itemRepo;

    // ✅ Job
    @Bean
    public Job orderJob(JobRepository jobRepository, Step orderStep) {
        return new JobBuilder("orderJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(orderStep)
                .listener(new JobExecutionListener() {
                    @Override
                    public void afterJob(JobExecution jobExecution) {
                        if (jobExecution.getStatus() == BatchStatus.FAILED) {
                            System.err.println("⚠️ Job failed gracefully: " +
                                    jobExecution.getAllFailureExceptions());
                        }
                    }
                })
                .build();
    }

    // ✅ Step
    @Bean
    public Step oderStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("oderStep", jobRepository)
                .<Order, Order>chunk(2, transactionManager)
                .reader(jsonItemReader())
                .processor(orderProcessor())
                .writer(orderWriter())
//                .listener(new StepExecutionListener() {
//                    @Override
//                    public ExitStatus afterStep(StepExecution stepExecution) {
//                        if (stepExecution.getStatus() == BatchStatus.FAILED) {
//                            System.err.println("✅ Step rolled back gracefully.");
//                        }
//                        return stepExecution.getExitStatus();
//                    }
//                })
                .build();
    }

    // ✅ JSON Reader
    @Bean
    public JsonItemReader<Order> jsonItemReader() {
        return new JsonItemReaderBuilder<Order>()
                .name("orderJsonItemReader")
                .jsonObjectReader(new JacksonJsonObjectReader<>(Order.class))
                .resource(new ClassPathResource("order.json"))
                .build();
    }

    // ✅ Processor (optional): validate items
    @Bean
    public ItemProcessor<Order, Order> orderProcessor() {
        // Build Jakarta validator
        Validator jakartaValidator = Validation.buildDefaultValidatorFactory().getValidator();

        // Wrap it in a Spring adapter
        SpringValidatorAdapter springValidatorAdapter = new SpringValidatorAdapter(jakartaValidator);

        // Plug into Spring Batch validator
        SpringValidator<Order> validator = new SpringValidator<>();
        validator.setValidator(springValidatorAdapter);

        return order -> {
            try {
                System.out.println("Processing order: " + order);
                validator.validate(order);
                return order;
            } catch (ValidationException e) {
                System.err.println("⚠️ Validation failed for order: " + order.getOrderId());
                System.err.println("Reason: " + e.getMessage());
                return null; // skip invalid
            }
        };
    }

    // ✅ Writer
    @Bean
    public ItemWriter<Order> orderWriter() {
        return items -> {
            int i = 0; //Test transaction
            for (Order order : items) {
                try {
                    System.out.println("Writing order: " + order);
                    itemRepo.saveAll(order.getItems().stream().map(ItemEntity::new).toList());
                    //Insert/update other tables here
                    if (i > 0)
                        throw new RuntimeException("test transaction");
                    i++;
                } catch (Exception e) {
                    // Log and handle gracefully
                    System.err.println("⚠️ Caught exception, marking rollback: " + e.getMessage());
                    throw new GracefulRollbackException("test transaction");
                }
            }
        };
    }
}
