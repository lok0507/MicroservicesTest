package com.user.service.FeignService;

import com.user.service.Entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/hotels/{hotelid}")
    Hotel getHotelByHotelId(@PathVariable String hotelid);
}
