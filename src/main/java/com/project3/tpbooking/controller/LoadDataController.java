package com.project3.tpbooking.controller;

import com.project3.tpbooking.document.Hotel;
import com.project3.tpbooking.document.Room;
import com.project3.tpbooking.model.Partner;
import com.project3.tpbooking.model.User;
import com.project3.tpbooking.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(("/loaddata"))

public class LoadDataController {
    @Autowired
    private EsService esService;

    @Autowired
    private UserService userService;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RoomService roomService;


    @GetMapping("/ok")
    public String loadData(){
        List<Hotel> hotels = esService.getAll();
        int c = 1;
        User partner1 = userService.findByUsername("partner1");
        User partner2 = userService.findByUsername("partner2");
        User partner3 = userService.findByUsername("partner3");
        User partner;
        for(Hotel hotel: hotels){

            if(c<=100){
                partner = partner1;
            }else if(c<=200){
                partner = partner2;
            }else partner = partner3;
            c++;
            com.project3.tpbooking.model.Hotel newHotel = new com.project3.tpbooking.model.Hotel().setId(hotel.getId()).setUser(partner);
            com.project3.tpbooking.model.Hotel newSaveHotel = hotelService.save(newHotel);
            for(Room room : hotel.getRooms()){
                com.project3.tpbooking.model.Room newRoom = new com.project3.tpbooking.model.Room().setId(room.getId()).setHotel(newSaveHotel);
                roomService.save(newRoom);
            }
        }
        return "ok";
    }
}









