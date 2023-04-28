package com.user.service.Service;

import com.user.service.Entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);
    Optional<User> getUserById(String id);
    List<User> getUsers();
}
