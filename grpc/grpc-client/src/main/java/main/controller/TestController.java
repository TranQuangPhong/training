package main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import main.grpc.*;

@RestController
@RequestMapping
public class TestController {
    @GetMapping("/")
    public String getData() {
        Data data = Data.newBuilder().setId(1).setName("Phong").build();
        return "";
    }
}
