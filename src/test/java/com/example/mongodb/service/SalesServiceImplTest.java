package com.example.mongodb.service;

import com.example.mongodb.MongodbApplication;
import com.example.mongodb.repository.SalesRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MongodbApplication.class)
@ContextConfiguration(classes=MongodbApplication.class)
class SalesServiceImplTest {

    @MockBean
    private SalesRepository salesRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SalesService  salesService;

    @BeforeAll
    public static void setUp() {

    }

    @AfterAll
    public static void tearDown() {

    }

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