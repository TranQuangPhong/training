package com.controller;

import com.configuration.properties.ConfigServerProperties;
import com.model.DataModel;
import com.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RefreshScope
public class ServiceToServiceController {

    @Autowired
    DataService service;

    @GetMapping
    public String home() {
        return "Welcome to home page! This is service 1.";
    }

    @GetMapping("/data/config-server")
    public ConfigServerProperties getConfigServerData(){
        return service.getConfigServerData();
    }

    @GetMapping("/data")
    public DataModel getData() {
        return service.getDataModel();
    }

    @GetMapping("/data-service-2")
    public DataModel getDataFromService2() {
        return service.getDataFromService2();
    }

    @GetMapping("/data-service-2-3")
    public DataModel getDataFromService3ViaService2() {
        return service.getDataFromService3ViaService2();
    }

}
