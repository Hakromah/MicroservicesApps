package com.telusko.controller;

import com.telusko.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final GreetingService service;

    @Autowired
    private Environment env;

    public GreetingController(GreetingService service) {
        this.service = service;
    }

    @GetMapping("/greeting")
    public String getGreeting() {
        String portNo = env.getProperty("server.port");
        return "Greeting from MicroServer2 on port: " + portNo;
    }

    @GetMapping("/hello")
    ResponseEntity<String> getResponseEntity() {
        String status = service.getGreeting();
        return new ResponseEntity<>(status, HttpStatus.OK);
    }


}
