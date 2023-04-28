package com.hotel.service.Service;

import com.hotel.service.Entities.Hotel;
import com.hotel.service.Exceptions.ResourceNotFoundException;
import com.hotel.service.Repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        String id = UUID.randomUUID().toString();
        hotel.setId(id);
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotelById(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel not found from resource"));
    }

    @Override
    public List<Hotel> getAllHotels() {
        return null;
    }
}
