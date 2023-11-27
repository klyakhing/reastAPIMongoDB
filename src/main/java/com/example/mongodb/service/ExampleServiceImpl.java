package com.example.mongodb.service;

import com.example.mongodb.exception.ResourceNotFoundException;
import com.example.mongodb.model.Example;
import com.example.mongodb.repository.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExampleServiceImpl implements ExampleService{

    @Autowired
    private ExampleRepository exampleRepository;

    @Override
    public Example createExample(Example product) {
        return exampleRepository.save(product);
    }

    @Override
    public Example updateExample(String id, Example product) {
         Example  productDb = this.getExampleById(id);

        if (productDb != null) {

            productDb.setEmail(product.getEmail());
            productDb.setFirts_name(product.getFirts_name());
            productDb.setLast_name(product.getLast_name());
            productDb.setGender(product.getGender());
            productDb.setIp_address(product.getIp_address());
            exampleRepository.save(productDb);
            return productDb;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }

    @Override
    public List<Example> getAllExamples() {
        return this.exampleRepository.findAll();
    }

    @Override
    public Example getExampleById(String productId) {
        Optional < Example > productDb = this.exampleRepository.findById(productId);

        if (productDb.isPresent()) {
            return productDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + productId);
        }
    }

    @Override
    public void deleteExample(String id) {

        Example  productDb = this.getExampleById(id);

        if (productDb != null) {
            this.exampleRepository.delete(productDb);
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }

    }
}
