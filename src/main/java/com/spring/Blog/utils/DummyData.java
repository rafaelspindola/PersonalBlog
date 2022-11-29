package com.spring.Blog.utils;

import com.spring.Blog.model.Posts;
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

        List<Posts> postsList = new ArrayList<>(); //creates and arraylist of posts

        // simulates a real post
        Posts post1 = new Posts();
        post1.setAuthor("Rafael Spindola");
        post1.setDate(LocalDate.now());
        post1.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        post1.setTitle("First project");

        Posts post2 = new Posts();
        post2.setAuthor("Rafael Spindola");
        post2.setDate(LocalDate.now());
        post2.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        post2.setTitle("Second project");

        postsList.add(post1);
        postsList.add(post2);

        for(Posts post: postsList) {
            Posts postSaved = blogRepository.save(post);
            System.out.println(postSaved.getId());
        }

    }
}
