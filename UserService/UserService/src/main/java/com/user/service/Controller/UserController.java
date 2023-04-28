package com.user.service.Controller;

import com.user.service.Entities.User;
import com.user.service.Service.UserServiceImpl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
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
    @CircuitBreaker(name = "ratinghotelbreaker", fallbackMethod = "failureCallBackMethod")
    public Optional<User> getUserById(@PathVariable String userid) {
        return userService.getUserById(userid);
    }

    public Optional<User> failureCallBackMethod(String userid, Exception exception) {
        return Optional.ofNullable(User.builder().userid("12345").name("Dummy").about("Dummy user").build());
    }
}
