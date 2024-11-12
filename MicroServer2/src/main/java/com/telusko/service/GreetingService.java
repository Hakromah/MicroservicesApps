package com.telusko.service;

import com.telusko.feignclients.SchoolFeignClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {

    @Autowired
    private SchoolFeignClients feign;

    public String getGreeting() {
        ResponseEntity<List<?>> res = feign.fetchAllSchools();
        return "Greeting from MicroServer1 with response: " + res;
    }
}
