package com.spring.Blog.repository;

import com.spring.Blog.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository // gets access to methods like findAll, findById, save, delete
        extends JpaRepository<Posts,Long> { }

