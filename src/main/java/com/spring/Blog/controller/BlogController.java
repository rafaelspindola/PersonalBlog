package com.spring.Blog.controller;

import com.spring.Blog.model.Post;
import com.spring.Blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
@Controller
@RequestMapping
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping(path = "/posts") // selects/searches all posts
    public ModelAndView getPosts () {
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = blogService.findAll();
        mv.addObject("posts", posts);
        return mv;
    }

    @GetMapping(path = "/posts/{id}") // selects/searches a single post using an id
    public ModelAndView getPostDetails (@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("postDetails");
        Post post = blogService.findById(id);
        mv.addObject("post", post);
        return mv;
    }
    @GetMapping(path = "/newpost")
    public String getPostForm() {
        return "postForm";
    }
    @PostMapping(path = "newpost")
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) { // validates input from user
        if (result.hasErrors()) {
            return "redirect:/newpost";
        }
        post.setDate(LocalDate.now());
        blogService.save(post);
        return "redirect:/posts";
    }
}
