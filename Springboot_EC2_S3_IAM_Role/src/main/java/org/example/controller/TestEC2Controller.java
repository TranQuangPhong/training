package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.config.AwsProperties;
import org.example.model.Order;
import org.example.service.S3Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/ec2")
@RequiredArgsConstructor
public class TestEC2Controller {

    private final S3Service s3Service;
    private final AwsProperties awsProperties;

    private final String FILE_NAME = "order.json";

    @GetMapping("/dummy")
    public List<Order> dummy() throws IOException {
        return s3Service.readLocalJsonIbject(FILE_NAME);
    }

    @GetMapping
    public List<Order> getOrders() throws IOException {
        return s3Service.readS3JsonObject(awsProperties.getBucket(), FILE_NAME);
    }
}
