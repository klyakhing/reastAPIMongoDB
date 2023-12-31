package com.example.mongodb.controller;

import com.example.mongodb.model.Customer;
import com.example.mongodb.model.Sales;
import com.example.mongodb.repository.ExampleRepository;
import com.example.mongodb.repository.SalesRepository;
import com.example.mongodb.service.SalesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest
@AutoConfigureMockMvc
class SalesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SalesService saleService;

    @MockBean
    private SalesRepository salesRepository;

    @MockBean
    private ExampleRepository exampleRepository;

    @Autowired
    private ObjectMapper objectMapper;



    @Test
    void getAllSales() throws Exception{

        List<Sales> listOfSales = new ArrayList<>();

        Sales sale = new Sales();
        sale.setStoreLocation("Fedotovo");
        sale.setItems(null);
        sale.setItems(null);
        sale.setCustomer(new Customer("male", 20, "test@test.com", 4));
        sale.setPurchaseMethod("in store");
        listOfSales.add(sale);
        given(saleService.getAllSales()).willReturn(listOfSales);

        ResultActions response = mockMvc.perform(get("/api/sales"));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",
                        is(listOfSales.size())));

    }

    @Test
    void save() throws Exception{

        Sales sale = new Sales();
        ObjectId objectId = new ObjectId();
        sale.setId(objectId);
        sale.setStoreLocation("Fedotovo");
        sale.setItems(null);
        sale.setItems(null);
        sale.setCustomer(new Customer("male", 20, "test@test.com", 4));
        sale.setPurchaseMethod("in store");

        String jason = objectMapper.writeValueAsString(sale);
        String jsonInString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(sale);
        System.out.println(jsonInString);


        doReturn(sale).when(saleService).save(any());

        ResultActions response = mockMvc.perform(post("/api/sales")
                                         .contentType(MediaType.APPLICATION_JSON)
                                         .content(jsonInString))
                                              // Validate the response code and content type
                                         .andExpect(status().isCreated())
                                         .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().is(201))
                .andDo(print());

    }

    @Test
    void getSaleById() throws Exception{

        String id = "5bd761dcae323e45a93ccfe8";
        Sales sale = new Sales();


        given(saleService.getSaleById(id)).willReturn(sale);

        ResultActions response = mockMvc.perform(get("/api/sales/id"));

        response.andExpect(status().is(200))
                .andDo(print());
    }

    @Test
    void deleteSaleById() throws Exception{

        String id = "5bd761dcae323e45a93ccfe8";
        Sales sale = new Sales();


        given(saleService.deleteSaleById(id)).willReturn(1L);

        ResultActions response = mockMvc.perform(delete("/api/sales/id"));

        response.andExpect(status().is(200))
                .andDo(print());
    }

    @Test
    void update() throws Exception{

        String id = "5bd761dcae323e45a93ccfe8";
        Sales sale = new Sales();
        sale.setStoreLocation("Fedotovo");
        sale.setItems(null);
        sale.setItems(null);
        sale.setCustomer(new Customer("male", 20, "test@test.com", 4));
        sale.setPurchaseMethod("in store");

        String jason = objectMapper.writeValueAsString(sale);
        String jsonInString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(sale);
        System.out.println(jsonInString);


        doReturn(sale).when(saleService).update(any(), any());

        ResultActions response = mockMvc.perform(put("/api/sales/id")
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .content(jsonInString))
                                        .andExpect(status().isOk())
                                        .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().is(200))
                .andDo(print());
    }

    @Test
    void count() throws Exception{

        given(saleService.count()).willReturn(5000L);
        //doReturn(anyLong()).when(saleService).count();

        ResultActions response = mockMvc.perform(get("/api/sales/count"));

        response.andExpect(status().is(200))
                .andDo(print());

    }
}