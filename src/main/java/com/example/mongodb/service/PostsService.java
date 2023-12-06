package com.example.mongodb.service;

import com.example.mongodb.model.Posts;

import java.util.List;

public interface PostsService {

    public List<Posts> getAllPosts();

    public Posts getPostById(String id);

    public long deletePostById(String id);

    public Posts update(Posts personEntity, String id);

    public long count();

    public Posts save(Posts post);
}
