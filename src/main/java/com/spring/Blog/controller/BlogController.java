package com.spring.Blog.controller;

import com.spring.Blog.model.Post;
import com.spring.Blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequestMapping
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping(path = "/posts")
    public ModelAndView getPosts () {
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = blogService.findAll();
        mv.addObject("posts", posts);
        return mv;
    }
}
