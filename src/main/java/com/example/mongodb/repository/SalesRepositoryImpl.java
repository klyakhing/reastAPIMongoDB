package com.example.mongodb.repository;


import com.example.mongodb.model.Sales;
import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import jakarta.annotation.PostConstruct;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.ReturnDocument.AFTER;

@Repository
public class SalesRepositoryImpl implements SalesRepository{

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();

    private MongoCollection<Sales> salesCollection;


    private final MongoClient client;

    public SalesRepositoryImpl(MongoClient client) {
        this.client = client;
    }

    @PostConstruct
    void init() {
        salesCollection = client.getDatabase("sample_supplies").getCollection("sales", Sales.class);
    }

    @Override
    public List<Sales> getAllSales() {
        return salesCollection.find().limit(30).into(new ArrayList<>());
    }

    @Override
    public Sales getSaleById(String id) {
        return salesCollection.find(eq("_id", new ObjectId(id))).first();
    }

    @Override
    public long deleteSaleById(String id) {
        return salesCollection.deleteOne(eq("_id", new ObjectId(id))).getDeletedCount();
    }

    @Override
    public Sales update(Sales sales, String id) {
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions().returnDocument(AFTER);
        return salesCollection.findOneAndReplace(eq("_id", sales.getId()), sales, options);
    }

    @Override
    public long count() {
        return salesCollection.countDocuments();
    }

    @Override
    public Sales save(Sales post) {
        if(post != null){
            salesCollection.insertOne(post);
            return post;
        } else {
            return null;
        }
    }
}
