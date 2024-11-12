package com.telusko.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "MICROSERVER1")
public interface SchoolFeignClients {

//    @GetMapping("/getAllSchools")
//    public List<?> findAllSchools();

    @GetMapping("/getAllSchools")
    ResponseEntity<List<?>> fetchAllSchools();


}
