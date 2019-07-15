package com.dustyding.restful.restfulservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
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
        User user = service.findOne(id);
        if(user == null)
            throw new UserNotFoundException("id-"+id);
        return user;
    }

    @PostMapping("/users")
    public void addOne(@RequestBody User user){
        User newUser = service.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().
                path("/{id}").
                buildAndExpand(newUser.getID()).
                toUri();

        ResponseEntity.created(location).build();
    }
}
