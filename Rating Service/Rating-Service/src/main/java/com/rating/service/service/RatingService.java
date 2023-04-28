package com.rating.service.service;

import com.rating.service.entities.Rating;

import java.util.List;

public interface RatingService {

    Rating saveRating(Rating rating);

    Rating getRatingById(String ratingid);
    List<Rating> getAllRatings();

    List<Rating> getRatingByUserId(String userid);
    List<Rating> getRatingByHotelId(String hotelid);
}
