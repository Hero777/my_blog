package com.example.springbootblogadd.config;

import com.example.springbootblogadd.models.Account;
import com.example.springbootblogadd.models.Post;
import com.example.springbootblogadd.services.AccountService;
import com.example.springbootblogadd.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @Override
    public void run(String... args) throws Exception {
        List<Post> posts = postService.getAll();

        if (posts.isEmpty()) {

            Account account1 = new Account();
            Account account2 = new Account();

            account1.setFirstName("user");
            account1.setLastName("user");
            account1.setEmail("user.user@mail.com");
            account1.setPassword("password");

            account2.setFirstName("admin");
            account2.setLastName("admin");
            account2.setEmail("admin.admin@mail.com");
            account2.setPassword("password");

            accountService.save(account1);
            accountService.save(account2);

            Post post1 = new Post();
            post1.setTitle("title of the post1");
            post1.setBody("This is the body of post1");
            post1.setAccount(account1);

            Post post2 = new Post();
            post2.setTitle("title of the post2");
            post2.setBody("This is the body of post2");
            post2.setAccount(account2);

            postService.save(post1);
            postService.save(post2);
        }
    }
}
