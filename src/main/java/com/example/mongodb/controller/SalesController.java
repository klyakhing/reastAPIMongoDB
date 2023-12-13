package com.example.mongodb.controller;


import com.example.mongodb.model.Sales;
import com.example.mongodb.service.SalesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SalesController {

    private final static Logger LOGGER = LoggerFactory.getLogger(SalesController.class);

   private final SalesService  salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping("/sales")
    public List<Sales> getAllSales(){

        return salesService.getAllSales();
    }

    @PostMapping("/sales")
    @ResponseStatus(HttpStatus.CREATED)
    public Sales save(@RequestBody Sales sale) {
        return salesService.save(sale);
    }

    @GetMapping("/sales/{id}")
    public Sales getSaleById(String id){
        return salesService.getSaleById(id);
    }

    @DeleteMapping("/sales/{id}")
    public long deleteSaleById(String id){
        return salesService.deleteSaleById(id);
    }

    @PutMapping("/sales/{id}")
    public Sales update(@RequestBody Sales sale, String id) {
        return salesService.update(sale, id);
    }

    @GetMapping("sales/count")
    public long count() {
        return salesService.count();
    }

}
