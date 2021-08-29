package com.fagenius.spring.data.jpa.demo.controllers;

import com.fagenius.spring.data.jpa.demo.entities.Post;
import com.fagenius.spring.data.jpa.demo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public List<Post> getAllPosts(){
        List<Post> posts = new ArrayList<>();
        postService.getAllPosts().forEach(posts::add);
        return posts;
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public Optional<Post> getPost(@PathVariable String id){
        return postService.getPost(id);
    }

    @RequestMapping(value = "/posts/add", method = RequestMethod.POST)
    public void addPost(@RequestBody Post post){
        postService.addPost(post);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
    public void updatePost(@RequestBody Post post, @PathVariable String id){
        for (int i=0; i<postService.getAllPosts().size(); i++){
            Post pt = postService.getAllPosts().get(i);
            if(pt.getId().equals(id)){
                postService.updatePost(post,id);
                i = postService.getAllPosts().size()+10;
            }
        }
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable String id){
        postService.deletePost(id);
    }

}
