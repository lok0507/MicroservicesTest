package com.user.service.Controller;

import com.user.service.Entities.User;
import com.user.service.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping
    public User saveUser(@RequestBody User user) {
        User user1 = userService.createUser(user);
        return user1;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userid}")
    public Optional<User> getUserById(@PathVariable String userid) {
        return userService.getUserById(userid);
    }
}
