package com.user.service.Service;

import com.user.service.Entities.Hotel;
import com.user.service.Entities.Rating;
import com.user.service.Entities.User;
import com.user.service.Exceptions.ResourceNotFoundException;
import com.user.service.FeignService.HotelService;
import com.user.service.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HotelService hotelService;

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

        Rating[] ratings = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+id, Rating[].class);
        List<Rating> ratingList = Arrays.asList(ratings);

        List<Rating> ratingListResult =  ratingList.stream().map(rating -> {

            Hotel hotel = hotelService.getHotelByHotelId(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).toList();
        user.get().setRatings(ratingListResult);
        return user;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        for(User user : users) {
            Rating[] ratings = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserid(), Rating[].class);
            user.setRatings(Arrays.asList(ratings));
        }
        return users;
    }
}
