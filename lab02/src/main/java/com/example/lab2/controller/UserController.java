package com.example.lab2.controller;

import com.example.lab2.entity.User;
import com.example.lab2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> findAll() {
        return this.userService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable int id) {
        return this.userService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody User user) {
       this.userService.addAndUpdateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        this.userService.deleteUserById(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody User user) {
        this.userService.addAndUpdateUser(user);
    }
}
