package com.usa.reto2.controller;

import com.usa.reto2.model.User;
import com.usa.reto2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") int id){
        return userService.getUser(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return userService.delete(id);
    }
    @GetMapping("/{email}/{password}")
    public User authenticate(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.authenticateUser(email, password);
    }
    @GetMapping("/emailexist/{email}")
    public boolean emailexist(@PathVariable("email") String email) {
        return userService.emailexist(email);
    }
}
