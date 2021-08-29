package com.fagenius.spring.data.jpa.demo.repositories;

import com.fagenius.spring.data.jpa.demo.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,String> {
    public List<User> findByLocationId(String locationid);
    public List<User> findByFirstname(String name);
}
