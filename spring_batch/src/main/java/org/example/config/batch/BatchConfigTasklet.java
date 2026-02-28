package org.example.config.batch;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.example.model.dto.Item;
import org.example.model.dto.Order;
import org.example.model.entity.ItemEntity;
import org.example.repo.ItemRepo;
import org.springframework.batch.core.*;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class BatchConfigTasklet {

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

    // ✅ Step (Tasklet-style)
    @Bean
    public Step orderStep(JobRepository jobRepository,
                          PlatformTransactionManager transactionManager,
                          Validator validator) {
        return new StepBuilder("orderStep", jobRepository)
                .tasklet(orderTasklet(validator), transactionManager)
                .build();
    }

    // ✅ The tasklet — read all input, validate, then save in one transaction
    @Bean
    public Tasklet orderTasklet(Validator validator) {
        return (contribution, chunkContext) -> {
            System.out.println("🚀 Starting Tasklet: reading and validating orders");

            // Step 1: Read all orders from JSON
            JsonItemReader<Order> reader = jsonItemReader();
            reader.open(chunkContext.getStepContext().getStepExecution().getExecutionContext());

            List<Order> orders = new ArrayList<>();
            Order order;
            while ((order = reader.read()) != null) {
                orders.add(order);
            }
            reader.close();

            System.out.println("✅ Loaded " + orders.size() + " orders from JSON");

            // Step 2: Validate orders (before DB transaction)
            validateOrders(orders, validator);

            // Step 3: Save all valid orders in one transaction
            processAndSaveAll(orders);

            System.out.println("🎉 All orders saved successfully.");
            return RepeatStatus.FINISHED;
        };
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

//    @Bean //For reading json from S3
//    public S3JsonItemReader<Order> s3Reader(S3Client s3Client) {
//        String bucketName = "your-s3-bucket-name";
//        String objectKey = "path/to/your-file.json";
//        return new S3JsonItemReader<>(s3Client, bucketName, objectKey, Order.class);
//    }

    // ✅ Validation logic (outside of @Transactional)
    public void validateOrders(List<Order> orders, Validator validator) {
        for (Order order : orders) {
            Set<ConstraintViolation<Order>> violations = validator.validate(order);
            if (!violations.isEmpty()) {
                System.err.println("❌ Validation failed for order: " + order.getOrderId());
                violations.forEach(v ->
                        System.err.println("   - " + v.getPropertyPath() + ": " + v.getMessage())
                );
                throw new RuntimeException("Validation failed for order: " + order.getOrderId());
            }
        }
    }

    /**
     * ✅ Save logic (single transaction)
     *
     * 1. Tasklet auto applies transaction in 1 step --> no need @Transactional (can remove the annotation)
     * 2. If we set Tasklet not to use transaction, then must use @Transactional
     * & must move this method to another class to apply @Transactional (example: a service class)
     *
     * @param orders
     */
    @Transactional(rollbackFor = {Exception.class, Throwable.class}) //Can be removed as Tasklet auto applies transaction
    public void processAndSaveAll(List<Order> orders) {
        //Option 1. loop
        for (Order order : orders) {
            System.out.println("💾 Saving order: " + order.getOrderId());
            itemRepo.saveAll(order.getItems().stream().map(ItemEntity::new).toList());
            //insert/update customer table here
            //insert/update other tables here
        }
        //Option 2. saveAll()
//        List<Item> itemList = orders.stream().flatMap(order -> order.getItems().stream()).toList();
//        List<ItemEntity> itemEntityList = itemList.stream().map(ItemEntity::new).toList();
//        itemRepo.saveAll(itemEntityList);
    }
}
