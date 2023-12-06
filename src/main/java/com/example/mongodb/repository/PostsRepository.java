package com.example.mongodb.repository;

import com.example.mongodb.model.Posts;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository {

    public List<Posts> getAllPosts();

    public Posts getPostById(String id);

    public long deletePostById(String id);

    public Posts update(Posts personEntity, String id);

    public long count();

    public Posts save(Posts post);
}
