package com.example.mongodb.repository;

import com.example.mongodb.model.Example;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExampleRepository extends MongoRepository<Example, String> {
}
