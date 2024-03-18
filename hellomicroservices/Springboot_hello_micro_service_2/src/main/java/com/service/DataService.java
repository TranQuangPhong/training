package com.service;

import com.model.DataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Service
public class DataService {

    @Autowired
    WebClient.Builder webClientBuilder;

    public DataModel getDataModel(){
        return new DataModel(20L, "data_1_service_2");
    }

    public DataModel getDataFromService3(){
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8083/v1/data")
                .retrieve()
                .bodyToMono(DataModel.class)
                .block(Duration.ofSeconds(10));
    }
}
