package com.example.mongodb.service;

import com.example.mongodb.MongodbApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MongodbApplication.class)
@ContextConfiguration(classes=MongodbApplication.class)
class SalesServiceImplTest {

    @Test
    void getAllSales() {
    }

    @Test
    void getSaleById() {
    }

    @Test
    void deleteSaleById() {
    }

    @Test
    void update() {
    }

    @Test
    void count() {
    }

    @Test
    void save() {
    }
}