package com.rating.service.repositories;

import com.rating.service.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, String> {

    @Query("select r from Rating r where r.userId = ?1")
    List<Rating> findRatingByUserId(String userid);

    @Query("select r from Rating r where r.hotelId = :hotelid")
    List<Rating> findRatingByHotelId(@Param("hotelid") String hotelid);

    @Query("select r from Rating r where r.userId = ?1 and r.hotelId = ?2")
    Rating findRatingByUserIdAndHotelId(String userId, String hotelId);
}
