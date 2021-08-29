package com.fagenius.spring.data.jpa.demo.controllers;

import com.fagenius.spring.data.jpa.demo.entities.User;
import com.fagenius.spring.data.jpa.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        userService.getAllusers().forEach(users::add);
        return users;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public Optional<User> getUser(@PathVariable String id){
        return userService.getuser(id);
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @RequestMapping(value = "users/{id}", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user, @PathVariable String id){
        for(int i=0; i<userService.getAllusers().size(); i++){
            User us = userService.getAllusers().get(i);
            if(us.getId().equals(id)){
                userService.updateUser(user,id);
                i = userService.getAllusers().size()+9;
            }
        }
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE )
    public void deleteUser(@PathVariable String id){
        userService.deleteUser(id);
    }
    
    @RequestMapping(value = "/users/location/{id}", method = RequestMethod.GET)
    public List<User> getUsersByLocationId(@PathVariable String id){
        return userService.getUsersByLocationId(id);
    }

    @RequestMapping(value = "/users/firstname/{id}", method = RequestMethod.GET)
    public List<User> getUsersByFirstName(@PathVariable String firstName){
        return userService.getUsersByFirstName(firstName);
    }

}
