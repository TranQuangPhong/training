package com.service;

import com.configuration.properties.ConfigServerProperties;
import com.model.DataModel;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.repo.IDataRepository;
import io.netty.handler.timeout.TimeoutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Service
public class DataService {

    @Autowired
    WebClient.Builder webClientBuilder;

    @Autowired
    ConfigServerProperties configServerProperties;

    @Autowired
    IDataRepository repo;

//    @Autowired
//    DiscoveryClient discoveryClient;

    public ConfigServerProperties getConfigServerData() {
        return configServerProperties;
    }

    public DataModel getDataModel() {

        Long maxId = repo.getMaxId();
        repo.save(new DataModel(maxId + 1L, "data_1_service_1"));
        return repo.findAll().stream().findAny().orElse(new DataModel());
    }

    @HystrixCommand(defaultFallback = "getDataFromService2Fallback",
            threadPoolKey = "getDataFromService2FallbackPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            },
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            })
    public DataModel getDataFromService2() {

        HttpClient httpClient = HttpClient.create().responseTimeout(Duration.ofSeconds(3));
        ReactorClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);

        return webClientBuilder.clientConnector(connector)
                .build()
                .get()
                .uri("http://hello-service-2/v1/data")
                .retrieve()
                .bodyToMono(DataModel.class)
                .doOnError(TimeoutException.class, ex -> {
                    System.out.println("FAILED TO REACH SERVICE-2");
                })
                .doOnError(WebClientResponseException.class, ex -> {
                    System.out.println("FAILED TO REACH SERVICE-2");
                })
//                .timeout(Duration.ofSeconds(3))
                .block();
    }

    @HystrixCommand(defaultFallback = "getDataFromService3ViaService2Fallback",
            threadPoolKey = "getDataFromService3ViaService2FallbackPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            },
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            })
    public DataModel getDataFromService3ViaService2() {

        return webClientBuilder.build()
                .get()
                .uri("http://hello-service-2/v1/data-service-3")
                .retrieve()
                .bodyToMono(DataModel.class)
                .block(Duration.ofSeconds(10));
    }


    public DataModel getDataFromService2Fallback() {

        return new DataModel(2L, "data_2_service_1_fallback_service_2");
    }

    public DataModel getDataFromService3ViaService2Fallback() {

        return new DataModel(2L, "data_3_service_1_fallback_service_3_via_service_2");
    }
}
