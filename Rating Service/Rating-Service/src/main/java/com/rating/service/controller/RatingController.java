package com.rating.service.controller;

import com.rating.service.entities.Rating;
import com.rating.service.exceptions.DuplicateInsertion;
import com.rating.service.service.RatingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    RatingServiceImpl ratingService;

    @PostMapping
    public Rating saveRating(@RequestBody Rating rating) {
        return ratingService.saveRating(rating);
    }

    @GetMapping
    public List<Rating> getAllRatings() {
        return ratingService.getAllRatings();
    }

    @GetMapping("/{ratingid}")
    public Rating findRatingByRatingId(@PathVariable String ratingid) {
        return ratingService.getRatingById(ratingid);
    }

    @GetMapping("/users/{userid}")
    public List<Rating> findRatingByUserId(@PathVariable String userid) {
        return ratingService.getRatingByUserId(userid);
    }

    @GetMapping("/hotels/{hotelid}")
    public List<Rating> findRatingByHotelId(@PathVariable String hotelid) {
        return ratingService.getRatingByHotelId(hotelid);
    }
}
