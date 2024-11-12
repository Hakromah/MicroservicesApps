package com.telusko.controller;

import com.telusko.entity.Schools;
import com.telusko.service.SchoolsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Schools Controller")
public class SchoolsController {

    @Autowired
    private SchoolsService service;


    private Environment env;

    public SchoolsController(Environment env) {
        this.env = env;
    }

    @Operation(summary = "Post method", description = "Add School Details to database")
    @PostMapping("/addSchools")
    ResponseEntity<String> addSchools(@RequestBody Schools schools) {


        String status = service.registerSchool(schools);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping("/getAllSchools")
    @Operation(summary = "Get method", description = "Get All School Details from database")
    ResponseEntity<List<Schools>> fetchAllSchools() {

        String portNo = env.getProperty("server.port");
        System.out.println(portNo);

        List<Schools> status = service.findAllSchools();
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping("/getSchoolById/{id}")
    @Operation(summary = "Get method", description = "Get School Details by ID from database")
    ResponseEntity<Schools> getSchoolsById(@PathVariable("id") Long id) {
        Schools status = service.getSchoolById(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PutMapping("/updateSchools/{id}")
    @Operation(summary = "Put method", description = "Update School Details by ID in database")
    ResponseEntity<Schools> updateSchools(@PathVariable("id") Long id, @RequestBody Schools schools) {
        Schools status = service.updateSchool(id, schools);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @DeleteMapping("/deleteSchools/{id}")
    @Operation(summary = "Delete method", description = "Delete School Details by ID from database")
    ResponseEntity<?> deleteSchools(@PathVariable("id") Long id) {
        Object status = service.deleteSchoolById(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
