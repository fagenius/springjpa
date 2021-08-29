package com.fagenius.spring.data.jpa.demo.services;

import com.fagenius.spring.data.jpa.demo.entities.Post;
import com.fagenius.spring.data.jpa.demo.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts(){
        List<Post> posts = new ArrayList<>();
        postRepository.findAll().forEach(posts::add);
        return posts;
    }

    public void addPost(Post post){
        postRepository.save(post);
    }

    public Optional<Post> getPost(String id){
        return postRepository.findById(id);
    }

    public void updatePost(Post post, String id){
        postRepository.save(post);
    }

    public void deletePost(String id){
        postRepository.deleteById(id);
    }


}
