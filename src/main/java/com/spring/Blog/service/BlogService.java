package com.spring.Blog.service;

import com.spring.Blog.model.Posts;

import java.util.List;

public interface BlogService {

    List<Posts> findAll();
    Posts findById(Long id);
    Posts save(Posts post);
}
