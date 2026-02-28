package org.example.config.aws;

import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class AwsConfig {

//    @Bean
    public S3Client s3Client() {
        // Build the S3 client with your specific configuration
        // In a production environment, you would use a more robust way to handle credentials.
        return S3Client.builder()
                // .region(Region.US_EAST_1) // Uncomment if needed
                .build();
    }
}
