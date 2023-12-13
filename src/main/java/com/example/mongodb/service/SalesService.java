package com.example.mongodb.service;



import com.example.mongodb.model.Sales;

import java.util.List;

public interface SalesService {

    public List<Sales> getAllSales();

    public Sales getSaleById(String id);

    public long deleteSaleById(String id);

    public Sales update(Sales personEntity, String id);

    public long count();

    public Sales save(Sales post);
}
