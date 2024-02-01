package com.mruruc.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
public class Business {
    private DataService dataService;
    @Autowired
    public Business(@Qualifier(value = "mongodb") DataService dataService) {
        this.dataService = dataService;
    }

    public int findMax(){
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}
