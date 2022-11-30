package com.spring.Blog.utils;

import com.spring.Blog.model.Post;
import com.spring.Blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Component
public class DummyData {

    @Autowired
    BlogRepository blogRepository;
    //@PostConstruct // performs initialization after dependency injection
    public void savePosts() {

        List<Post> postList = new ArrayList<>(); //creates and arraylist of posts

        // simulates a real post
        Post post1 = new Post();
        post1.setAuthor("Rafael Spindola");
        post1.setDate(LocalDate.now());
        post1.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        post1.setTitle("First project");

        Post post2 = new Post();
        post2.setAuthor("Rafael Spindola");
        post2.setDate(LocalDate.now());
        post2.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        post2.setTitle("Second project");

        postList.add(post1);
        postList.add(post2);

        for(Post post: postList) {
            Post postSaved = blogRepository.save(post);
            System.out.println(postSaved.getId());
        }

    }
}
