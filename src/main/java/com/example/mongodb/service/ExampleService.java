package com.example.mongodb.service;

import com.example.mongodb.model.Example;

import java.util.List;

public interface ExampleService {

    Example createExample(Example product);

    Example updateExample(String id, Example product);

    List< Example > getAllExamples();

    Example getExampleById(String productId);

    void deleteExample(String id);
}
