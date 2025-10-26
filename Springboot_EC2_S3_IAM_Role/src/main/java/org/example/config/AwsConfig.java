package org.example.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
@RequiredArgsConstructor
public class AwsConfig {
    private final AwsProperties awsProperties;

    @Bean
    public S3Client s3Client() {
        //Use DefaultAWSCredentialsProviderChain
        return S3Client.builder()
                .region(awsProperties.getRegion())
                .build();
    }
}
