package org.example.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.regions.Region;

@Component
@ConfigurationProperties(prefix = "aws.s3")
@Getter
@Setter
public class AwsProperties {
    private Region region;
    private Credentials credentials; //Not used (because program is using DefaultAWSCredentialsProviderChain)
    private String bucket;

    @Getter
    @Setter
    public static class Credentials {
        private String accessKey;
        private String secretKey;
    }
}

