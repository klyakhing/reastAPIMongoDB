package com.example.mongodb.service;

import com.example.mongodb.model.Posts;
import com.example.mongodb.repository.PostsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsServiceImpl implements PostsService{
    private final PostsRepository postsRepository;

    public PostsServiceImpl(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    @Override
    public List<Posts> getAllPosts() {
        return postsRepository.getAllPosts();
    }

    @Override
    public Posts getPostById(String id) {
        return postsRepository.getPostById(id);
    }

    @Override
    public long deletePostById(String id) {
        return postsRepository.deletePostById(id);
    }

    @Override
    public Posts update(Posts post, String id) {
        return postsRepository.update(post, id);
    }

    @Override
    public long count() {
        return postsRepository.count();
    }

    @Override
    public Posts save(Posts post) {
        return postsRepository.save(post);
    }
}
