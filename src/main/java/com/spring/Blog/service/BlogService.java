package com.spring.Blog.service;

import com.spring.Blog.model.Post;

import java.util.List;

public interface BlogService {

    List<Post> findAll();
    Post findById(Long id);
    Post save(Post post);
}
