package com.example.mongodb.service;

import com.example.mongodb.MongodbApplication;
import com.example.mongodb.model.Customer;
import com.example.mongodb.model.Sales;
import com.example.mongodb.repository.SalesRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

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

    private static List<Sales> arr = null;
    private static Sales sale = null;
    private static String markedId = null;

    @BeforeAll
    public static void setUp() {

        arr = new ArrayList<>();
        sale = new Sales();
        ObjectId objectId = new ObjectId();
        markedId = objectId.toString();
        System.out.println("markedId="+markedId);

        sale.setId(objectId);
        sale.setStoreLocation("Ivanovo");
        sale.setItems(null);
        sale.setItems(null);
        sale.setCustomer(new Customer("male", 20, "test@test.com", 4));
        sale.setPurchaseMethod("in store");
        arr.add(sale);

    }

    @AfterAll
    public static void tearDown() {
        arr = null;
        sale = null;

    }

        @Test
    void getAllSales() throws Exception{

            doReturn(arr).when(salesRepository).getAllSales();

            // Execute the service call
            List<Sales> sales = salesService.getAllSales();

            // Assert the response
            Assertions.assertEquals(1, sales.size(), "getAllSales should return 1 sale");
    }

    @Test
    void getSaleById() throws Exception{

        doReturn(sale).when(salesRepository).getSaleById(markedId);

        // Execute the service call
        Sales sale = salesService.getSaleById(markedId);

        // Assert the response
        Assertions.assertTrue(sale != null, "sale is not null");
        Assertions.assertSame(sale.getStoreLocation(), "Ivanovo", "The sale returned was not the same as test sale");
    }

    @Test
    void deleteSaleById() throws Exception{

        doReturn(1L).when(salesRepository).deleteSaleById(markedId);

        // Execute the service call
        long ret = salesService.deleteSaleById(markedId);

        // Assert the response
        Assertions.assertTrue(ret > 0, "");
        Assertions.assertSame(ret, 1L, "");
    }

    @Test
    void update() throws Exception{
        doReturn(sale).when(salesRepository).update(sale, markedId);

        // Execute the service call
        Sales salen = salesService.update(sale, markedId);

        // Assert the response
        Assertions.assertNotNull(salen, "The saved sale should not be null");
        Assertions.assertEquals("Ivanovo", salen.getStoreLocation(), "store location - Ivanovo");
    }

    @Test
    void count() throws Exception {
        long n = 30;
        doReturn(n).when(salesRepository).count();

        // Execute the service call
        long m = salesService.count();

        // Assert the response
        Assertions.assertEquals(n, m, "");
    }

    @Test
    void save() throws Exception {

        doReturn(sale).when(salesRepository).save(any());

        // Execute the service call
        Sales salen = salesService.save(sale);

        // Assert the response
        Assertions.assertNotNull(salen, "The saved sale should not be null");
        Assertions.assertEquals("Ivanovo", salen.getStoreLocation(), "store location - Ivanovo");
    }
}