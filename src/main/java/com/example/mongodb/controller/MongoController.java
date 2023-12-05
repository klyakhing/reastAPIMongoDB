package com.example.mongodb.controller;

import com.example.mongodb.model.Example;
import com.example.mongodb.model.Inspection;
import com.example.mongodb.repository.ExampleRepository;
import com.example.mongodb.repository.InspectionRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import com.example.mongodb.service.ExampleService;

@RestController
public class MongoController {


    @Autowired
    private ExampleService exampleService;

    @Autowired


    /*@GetMapping(value = "/")
    public void redirect(@NotNull HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui/index.html");
    }*/



    @GetMapping(value = "/examples")
    public List<Example> getAllExamples(){

        return exampleService.getAllExamples();
    }

    @GetMapping("/examples/{id}")
    public ResponseEntity < Example > getProductById(@PathVariable String id) {
        return ResponseEntity.ok().body(exampleService.getExampleById(id));
    }

    @PostMapping("/examples")
    public ResponseEntity < Example > createProduct(@RequestBody Example product) {
        return ResponseEntity.ok().body(this.exampleService.createExample(product));
    }

    @PutMapping("/examples/{id}")
    public ResponseEntity < Example > updateProduct(@PathVariable String id, @RequestBody Example product) {

        return ResponseEntity.ok().body(this.exampleService.updateExample(id, product));
    }

    @DeleteMapping("/examples/{id}")
    public HttpStatus deleteProduct(@PathVariable String id) {
        this.exampleService.deleteExample(id);
        return HttpStatus.OK;
    }
}
