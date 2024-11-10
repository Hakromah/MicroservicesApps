package com.telusko.controller;

import com.telusko.service.GreetingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final GreetingService service;

    public GreetingController(GreetingService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    ResponseEntity<String> getResponseEntity() {
        String status = service.getGreeting();
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
