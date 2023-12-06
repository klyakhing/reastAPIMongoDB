package com.example.mongodb.repository;

import com.example.mongodb.model.Posts;
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
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.ReturnDocument.AFTER;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostsRepositoryImpl implements PostsRepository{

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();

    private final MongoClient client;
    private MongoCollection<Posts> postsCollection;

    public PostsRepositoryImpl(MongoClient mongoClient) {
        this.client = mongoClient;
    }

    @PostConstruct
    void init() {
        postsCollection = client.getDatabase("sample_training").getCollection("posts", Posts.class);
    }

    @Override
    public List<Posts> getAllPosts() {
        return postsCollection.find().limit(30).into(new ArrayList<>());
    }

    @Override
    public Posts getPostById(String id) {
        return postsCollection.find(eq("_id", new ObjectId(id))).first();
    }

    @Override
    public long deletePostById(String id) {
        return postsCollection.deleteOne(eq("_id", new ObjectId(id))).getDeletedCount();
    }

    @Override
    public Posts update(Posts posts, String id) {
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions().returnDocument(AFTER);
        return postsCollection.findOneAndReplace(eq("_id", posts.getId()), posts, options);
    }

    @Override
    public long count() {
        return postsCollection.countDocuments();
    }

    @Override
    public Posts save(Posts post){
        if(post != null){
            postsCollection.insertOne(post);
            return post;
        } else {
            return null;
        }

    }
}
