//package org.example.config.batch.components;
//
//import org.example.model.dto.Order;
//import org.springframework.batch.item.validator.BeanValidatingItemProcessor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class CustomProcessor {
//
//    // Using BeanValidatingItemProcessor for JSR-303 annotated beans
//    @Bean
//    public BeanValidatingItemProcessor<Order> validatingProcessor() {
//        BeanValidatingItemProcessor<Order> processor = new BeanValidatingItemProcessor<>();
//
//        // This is crucial: if a validation error occurs,
//        // it filters the item instead of throwing an exception.
//        // If you want to handle the exception, set it to `false` and configure a SkipListener.
//        processor.setFilter(true);
//
//        return processor;
//    }
//}
//
