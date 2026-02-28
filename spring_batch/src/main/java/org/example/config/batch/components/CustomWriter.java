//package org.example.config.batch.components;
//
//import org.example.model.dto.Order;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.support.CompositeItemWriter;
//import org.springframework.batch.item.database.JdbcBatchItemWriter;
//import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import javax.sql.DataSource;
//import java.util.Arrays;
//
//@Configuration
//public class CustomWriter {
//
//    private final DataSource dataSource;
//
//    public CustomWriter(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    @Bean
//    public ItemWriter<Order> compositeOrderWriter() {
//        CompositeItemWriter<Order> writer = new CompositeItemWriter<>();
//        writer.setDelegates(Arrays.asList(
//                customerItemWriter(),
//                orderItemWriter(),
//                itemWriter()
//        ));
//        return writer;
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<Order> customerItemWriter() {
//        return new JdbcBatchItemWriterBuilder<Order>()
//                .dataSource(dataSource)
//                .sql("INSERT INTO customers (name, email) VALUES (:customer.name, :customer.email)")
//                .beanMapped()
//                .build();
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<Order> orderItemWriter() {
//        // This is a simplified example. In reality, you'd need to handle foreign keys
//        return new JdbcBatchItemWriterBuilder<Order>()
//                .dataSource(dataSource)
//                .sql("INSERT INTO orders (orderId, customer_id) VALUES (:orderId, some_function_to_get_customer_id())")
//                .beanMapped()
//                .build();
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<Order> itemWriter() {
//        return new JdbcBatchItemWriterBuilder<Order>()
//                .dataSource(dataSource)
//                .sql("INSERT INTO order_items (itemId, quantity, order_id) VALUES (:items[0].itemId, :items[0].quantity, some_function_to_get_order_id())")
//                .beanMapped()
//                .build();
//    }
//}
//
