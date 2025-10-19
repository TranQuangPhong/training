package org.example.config.batch.components;

import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.core.io.InputStreamResource;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;

import java.io.InputStream;

public class S3JsonItemReader<T> extends JsonItemReader<T> {

    public S3JsonItemReader(S3Client s3Client, String bucketName, String objectKey, Class<T> targetType) {
        super();

        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(objectKey)
                .build();

        // Get the S3 object content as an InputStream
        InputStream s3InputStream = s3Client.getObject(getObjectRequest);
        InputStreamResource inputStreamResource = new InputStreamResource(s3InputStream);

        this.setResource(inputStreamResource);

        // This is a new approach in Spring Batch 5+ for JSON reading
        this.setJsonObjectReader(new JacksonJsonObjectReader<>(targetType));
    }
}

