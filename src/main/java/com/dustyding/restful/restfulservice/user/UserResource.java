package com.dustyding.restful.restfulservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService service;

    @GetMapping("/users")
    public List<User> allUsers(){
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User findOne(@PathVariable int id){
        return service.findOne(id);
    }

    @PostMapping("/users")
    public User addOne(@RequestBody User user){
        return service.save(user);
    }
}
