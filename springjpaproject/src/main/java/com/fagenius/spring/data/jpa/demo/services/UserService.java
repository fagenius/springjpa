package com.fagenius.spring.data.jpa.demo.services;

import com.fagenius.spring.data.jpa.demo.entities.Location;
import com.fagenius.spring.data.jpa.demo.entities.User;
import com.fagenius.spring.data.jpa.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllusers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public Optional<User> getuser(String id){
        return userRepository.findById(id);
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public void updateUser(User user, String id){
        userRepository.save(user);
    }

    public void deleteUser(String id){
        userRepository.deleteById(id);
    }

    public List<User> getUsersByLocationId(String id) {
        return userRepository.findByLocationId(id);
    }

    public List<User> getUsersByFirstName(String firstName) {
        return userRepository.findByFirstname(firstName);
    }
}
