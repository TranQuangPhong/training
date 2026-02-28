package org.example.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.model.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
@RequiredArgsConstructor
public class S3Service {
    private final S3Client s3Client;

    private static final ObjectMapper mapper = new ObjectMapper();

    public List<Order> readLocalJsonIbject(String fileName) throws IOException {
        ClassPathResource resource = new ClassPathResource(fileName);
        try (InputStream inputStream = resource.getInputStream()) {
            return mapper.readValue(inputStream, new TypeReference<List<Order>>() {
            });
        }
    }

    public List<Order> readS3JsonObject(String bucket, String objectKey) throws IOException {
        InputStream inputStream = getS3Object(bucket, objectKey);
        return mapper.readValue(inputStream, new TypeReference<List<Order>>() {
        });
    }

    public InputStream getS3Object(String bucket, String objectKey) {
        GetObjectRequest request = GetObjectRequest.builder().bucket(bucket).key(objectKey).build();
        return s3Client.getObject(request);
    }
}
