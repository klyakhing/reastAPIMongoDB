package com.example.mongodb.repository;


import com.example.mongodb.model.Inspection;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InspectionRepository extends MongoRepository<Inspection, String> {
}
