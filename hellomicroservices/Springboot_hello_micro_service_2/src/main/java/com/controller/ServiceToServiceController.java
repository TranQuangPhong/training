package com.controller;

import com.model.DataModel;
import com.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class ServiceToServiceController {

    @Autowired
    DataService service;

    @GetMapping
    public String home() {
        return "Welcome to home page! This is service 2.";
    }

    @GetMapping("/data")
    public DataModel getData() {
        return service.getDataModel();
    }

    @GetMapping("/data-service-3")
    public DataModel getDataFromService3() {
        return service.getDataFromService3();
    }

}
