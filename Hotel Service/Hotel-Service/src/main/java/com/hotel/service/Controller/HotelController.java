package com.hotel.service.Controller;

import com.hotel.service.Entities.Hotel;
import com.hotel.service.Service.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    HotelServiceImpl hotelService;

    @PostMapping
    public Hotel saveHotel(@RequestBody Hotel hotel) {
        return hotelService.createHotel(hotel);
    }

    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/{hotelid}")
    public Hotel getHotelById(@PathVariable String hotelid) {
        return hotelService.getHotelById(hotelid);
    }
}
