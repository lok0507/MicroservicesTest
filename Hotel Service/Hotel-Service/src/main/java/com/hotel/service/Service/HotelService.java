package com.hotel.service.Service;

import com.hotel.service.Entities.Hotel;

import java.util.List;

public interface HotelService {

    public Hotel createHotel(Hotel hotel);
    public  Hotel getHotelById(String id);
    public List<Hotel> getAllHotels();
}
