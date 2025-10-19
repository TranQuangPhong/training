package org.example.config.aws;

import lombok.Getter;
import lombok.Setter;
import software.amazon.awssdk.regions.Region;

//@ConfigurationProperties(prefix = "aws.s3")
@Getter
@Setter
public class AwsProperties {
    private Region region;
    private Credentials credentials;

    @Getter
    @Setter
    public static class Credentials {
        private String accessKey;
        private String secretKey;
    }
}

