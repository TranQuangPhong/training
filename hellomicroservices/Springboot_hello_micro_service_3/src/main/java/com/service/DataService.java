package com.service;

import com.model.DataModel;
import org.springframework.stereotype.Service;

@Service
public class DataService {
    public DataModel getDataModel(){
        return new DataModel(30L, "data_1_service_3");
    }
}
