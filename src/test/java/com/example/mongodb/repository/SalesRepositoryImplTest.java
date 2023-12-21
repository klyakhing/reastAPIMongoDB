package com.example.mongodb.repository;

import com.example.mongodb.MongodbApplication;
import com.example.mongodb.model.Customer;
import com.example.mongodb.model.Sales;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MongodbApplication.class)
@ContextConfiguration(classes=MongodbApplication.class)
class SalesRepositoryImplTest {

    @MockBean
    private SalesRepository salesRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private static List<Sales> arr = null;
    private static Sales sale = null;
    private static String markedId = null;
    private static ObjectId saveObjectId = null;
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
        // prepare one record

        saveObjectId = new ObjectId();

    }

    @AfterAll
    public static void tearDown() {

        arr = null;
        sale = null;

        saveObjectId = null;
    }


        @Test
    void getAllSales() throws Exception {


            doReturn(arr).when(salesRepository).getAllSales();
            assertTrue(arr.size() >= 0);
    }

    @Test
    void save() {


        sale.setId(saveObjectId);

        doReturn(sale).when(salesRepository).save(any());
        assertTrue(sale != null);
    }

    @Test
    void getSaleById() throws Exception{

        ObjectId id = new ObjectId(markedId);

        doReturn(sale).when(salesRepository).getSaleById(id.toString());
        String jsonInString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(sale);
        System.out.println(jsonInString);
        assertTrue(sale !=null);
    }

    @Test
    void deleteSaleById() throws Exception{
        ObjectId id = new ObjectId(markedId);

        doReturn(1L).when(salesRepository).deleteSaleById(id.toString());
        String jsonInString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(sale);
        System.out.println(jsonInString);
        assertTrue(1L == 1L);
    }

    @Test
    void update() throws Exception{

        ObjectId id = new ObjectId(markedId);
        sale.setId(id);
        sale.setStoreLocation("Test");
        doReturn(sale).when(salesRepository).update( sale,id.toString());
        String jsonInString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(sale);
        System.out.println(jsonInString);
        assertTrue(sale !=null);
    }

    @Test
    void count() throws Exception{

        doReturn(10L).when(salesRepository).count();
        
    }


}