package com.example.mongodb.controller;

import com.example.mongodb.model.Example;
import com.example.mongodb.model.Inspection;
import com.example.mongodb.repository.ExampleRepository;
import com.example.mongodb.repository.InspectionRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class MongoController {

    @Autowired
    ExampleRepository exampleRepository;

    @Autowired
    InspectionRepository inspectionRepository;

    @GetMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui/index.html");
    }



    @GetMapping(value = "/examples")
    public List<Example> getAllExamples(){

        return exampleRepository.findAll();
    }
}
