package com.project3.tpbooking.service;

import com.project3.tpbooking.data.model.request.BookingRoomRequest;
import com.project3.tpbooking.data.model.request.CancelRoomRequest;
import com.project3.tpbooking.data.model.request.ListRoomRequest;
import com.project3.tpbooking.data.model.response.BookingRoomResponse;
import com.project3.tpbooking.model.Reservation;
import com.project3.tpbooking.model.Room;
import com.project3.tpbooking.model.User;
import com.project3.tpbooking.repository.mysql.ReservationRepository;
import com.project3.tpbooking.repository.mysql.RoomRepository;
import com.project3.tpbooking.repository.mysql.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public BookingRoomResponse addBookingRoom(BookingRoomRequest request){
        System.out.println(request);
        User user = userRepository.getById(request.getUserId());
        Room room = roomRepository.getById(request.getRoomId());
        Reservation reservation = new Reservation().setUser(user)
                .setRoom(room)
                .setDateCheckin(request.getStartDay())
                .setDateCheckout(request.getEndDay())
                .setStatus(1);
        Reservation rs = reservationRepository.save(reservation);


        BookingRoomResponse response = new BookingRoomResponse()
                .setId(rs.getId())
                .setRoomId(request.getRoomId())
                .setStartDay(request.getStartDay())
                .setEndDay(request.getEndDay())
                .setStatus(rs.getStatus())
                .setHotelId(rs.getRoom().getHotel().getId())
                .setUserId(request.getUserId());

        return response;
    }

    public List<BookingRoomResponse> getListRoom(ListRoomRequest request){
        return reservationRepository.findByUser(request.getUserId())
                .stream().map(e->convert(e)).collect(Collectors.toList());
    }

    public int cancelRoom(CancelRoomRequest request){
        System.out.println(request.getReservationId());
        return reservationRepository.updateStatus(request.getReservationId(), 0);
    }

    public BookingRoomResponse convert(Reservation reservation){
        BookingRoomResponse response = new BookingRoomResponse()
                .setId(reservation.getId())
                .setRoomId(reservation.getRoom().getId())
                .setStartDay(reservation.getDateCheckin())
                .setEndDay(reservation.getDateCheckout())
                .setStatus(reservation.getStatus())
                .setHotelId(reservation.getRoom().getHotel().getId())
                .setUserId(reservation.getUser().getId());
        return response;
    }

}
