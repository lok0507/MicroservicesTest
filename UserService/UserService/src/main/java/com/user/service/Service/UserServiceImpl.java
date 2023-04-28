package com.user.service.Service;

import com.user.service.Entities.Rating;
import com.user.service.Entities.User;
import com.user.service.Exceptions.ResourceNotFoundException;
import com.user.service.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public User createUser(User user) {
        String randomId = UUID.randomUUID().toString();
        user.setUserid(randomId);
        User user1 = userRepository.save(user);
        return user1;
    }

    @Override
    public Optional<User> getUserById(String id) {
        Optional<User> user = Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found from resource!!")));

        ArrayList<Rating> ratings = restTemplate.getForObject("http://localhost:8083/ratings/users/"+id, ArrayList.class);
        user.get().setRatings(ratings);
        return user;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        for(User user : users) {
            ArrayList<Rating> ratings = restTemplate.getForObject("http://localhost:8083/ratings/users/"+user.getUserid(), ArrayList.class);
            user.setRatings(ratings);
        }
        return users;
    }
}
