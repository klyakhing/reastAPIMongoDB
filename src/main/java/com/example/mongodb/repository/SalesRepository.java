package com.example.mongodb.repository;


import com.example.mongodb.model.Sales;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepository {

    public List<Sales> getAllSales();

    public Sales getSaleById(String id);

    public long deleteSaleById(String id);

    public Sales update(Sales personEntity, String id);

    public long count();

    public Sales save(Sales post);
}
