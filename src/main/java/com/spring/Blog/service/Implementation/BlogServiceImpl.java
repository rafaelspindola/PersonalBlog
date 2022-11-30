package com.spring.Blog.service.Implementation;

import com.spring.Blog.model.Post;
import com.spring.Blog.repository.BlogRepository;
import com.spring.Blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service // declares that this class is related to business logic/functionalities, interacts with data sources
public class BlogServiceImpl implements BlogService {

    @Autowired //dependency injection
    BlogRepository blogRepository;

    @Override
    public List<Post> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return blogRepository.findById(id).get(); //needs .get because of the return value of findById
    }

    @Override
    public Post save(Post post) {
        return blogRepository.save(post);
    }
}
