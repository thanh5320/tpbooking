package com.project3.tpbooking.controller;

import com.project3.tpbooking.data.model.DfResponse;
import com.project3.tpbooking.data.model.request.BookingRoomRequest;
import com.project3.tpbooking.data.model.request.CancelRoomRequest;
import com.project3.tpbooking.data.model.request.ListRoomRequest;
import com.project3.tpbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/add/room")
    public ResponseEntity<?> bookingRoom(@RequestBody BookingRoomRequest request){
        return DfResponse.okEntity(bookingService.addBookingRoom(request));
    }

    @PostMapping("/list/room")
    public ResponseEntity<?> getListRoom(@RequestBody ListRoomRequest request){
        return DfResponse.okEntity(bookingService.getListRoom(request));
    }

    @PostMapping("/cancel/room")
    public ResponseEntity<?> cancelRoom(@RequestBody CancelRoomRequest request){
        return DfResponse.okEntity(bookingService.cancelRoom(request));
    }
}
