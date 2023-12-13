package com.example.mongodb.service;

import com.example.mongodb.model.Sales;
import com.example.mongodb.repository.SalesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesServiceImpl implements SalesService{

    private final SalesRepository salesRepository;

    public SalesServiceImpl(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    @Override
    public List<Sales> getAllSales() {
        return salesRepository.getAllSales();
    }

    @Override
    public Sales getSaleById(String id) {
        return salesRepository.getSaleById(id);
    }

    @Override
    public long deleteSaleById(String id) {
        return salesRepository.deleteSaleById(id);
    }

    @Override
    public Sales update(Sales sale, String id) {
        return salesRepository.update(sale, id);
    }

    @Override
    public long count() {
        return salesRepository.count();
    }

    @Override
    public Sales save(Sales sale) {
        return salesRepository.save(sale);
    }
}
