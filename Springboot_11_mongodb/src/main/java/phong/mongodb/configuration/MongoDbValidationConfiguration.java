package phong.mongodb.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class MongoDbValidationConfiguration {
    @Bean
    public ValidatingMongoEventListener validateMongoEventListener(){
        return new ValidatingMongoEventListener(validator());
    }
    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }
}
