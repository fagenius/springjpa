package com.fagenius.spring.data.jpa.demo.repositories;

import com.fagenius.spring.data.jpa.demo.entities.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post,String> {
}
