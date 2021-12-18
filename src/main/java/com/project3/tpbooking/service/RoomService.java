package com.project3.tpbooking.service;

import com.project3.tpbooking.model.Room;
import com.project3.tpbooking.repository.mysql.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public Room save(Room room){
        return roomRepository.save(room);
    }
}
