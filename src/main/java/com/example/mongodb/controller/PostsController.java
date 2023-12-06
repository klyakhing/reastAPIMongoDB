package com.example.mongodb.controller;

import com.example.mongodb.model.Posts;
import com.example.mongodb.service.PostsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostsController {

    private final static Logger LOGGER = LoggerFactory.getLogger(PostsController.class);
    private final PostsService postsService;

    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }

    @GetMapping("/posts")
    public List<Posts> getAllPosts(){

        return postsService.getAllPosts();
    }

    @PostMapping("/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Posts save(@RequestBody Posts post) {
        return postsService.save(post);
    }

    @GetMapping("/posts/{id}")
    public Posts getPostById(String id){
        return postsService.getPostById(id);
    }

    @DeleteMapping("/posts/{id}")
    public long deletePostById(String id){
        return postsService.deletePostById(id);
    }

    @PutMapping("/posts/{id}")
    public Posts update(@RequestBody Posts post, String id) {
        return postsService.update(post, id);
    }

    @GetMapping("posts/count")
    public long count() {
        return postsService.count();
    }

}
