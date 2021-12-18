package com.project3.tpbooking.service;

import com.project3.tpbooking.model.Hotel;
import com.project3.tpbooking.repository.mysql.HotelRepository;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
    @Autowired
    HotelRepository hotelRepository;

    public Hotel save(Hotel hotel){
         return hotelRepository.save(hotel);
    }
}
