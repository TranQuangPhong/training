package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class CommonConfiuration {

    @Bean
    public WebClient.Builder getWebClientbuilder(){
        return WebClient.builder();
    }
}
