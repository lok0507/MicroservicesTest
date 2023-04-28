package com.rating.service.service;

import com.rating.service.entities.Rating;
import com.rating.service.exceptions.ResourceNotFoundException;
import com.rating.service.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    RatingRepository ratingRepository;

    @Override
    public Rating saveRating(Rating rating) {
        String id = UUID.randomUUID().toString();
        rating.setRatingId(id);
        return ratingRepository.save(rating);
    }

    @Override
    public Rating getRatingById(String ratingid) {
        return ratingRepository.findById(ratingid).orElseThrow(() -> new ResourceNotFoundException("Rating not found from resource"));
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userid) {
        return ratingRepository.findRatingByUserId(userid);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelid) {
        return ratingRepository.findRatingByHotelId(hotelid);
    }

    public Rating findRatingByUserIdAndHotelId(String userid, String hotelid) {
        return ratingRepository.findRatingByUserIdAndHotelId(userid, hotelid);
    }
}
