package com.spring.Blog.repository;

import com.spring.Blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository // gets access to methods like findAll, findById, save, delete
        extends JpaRepository<Post,Long> { }

