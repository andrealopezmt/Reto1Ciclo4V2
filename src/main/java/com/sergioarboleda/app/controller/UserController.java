package com.sergioarboleda.app.controller;

import com.sergioarboleda.app.model.User;
import com.sergioarboleda.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*")

public class UserController {
    
    @Autowired
    private UserService service;

    
    @GetMapping("/all")
    public List<User> getUsers() {
        return service.getAll();
    }

    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){
        return service.save(user);
    }

    
    @GetMapping("/{email}")
    public boolean existEmail(@PathVariable("email") String email){
        return service.getUserByEmail(email);
    }

    
    @GetMapping("/{email}/{password}")
    public User authUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return service.getUserByEmailAndPassword(email, password);
    }
}
