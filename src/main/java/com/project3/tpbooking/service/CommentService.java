package com.project3.tpbooking.service;

import com.project3.tpbooking.data.model.request.CommentRequest;
import com.project3.tpbooking.data.model.response.CommentResponse;
import com.project3.tpbooking.model.Comment;
import com.project3.tpbooking.model.Hotel;
import com.project3.tpbooking.model.User;
import com.project3.tpbooking.repository.mysql.CommentRepository;
import com.project3.tpbooking.repository.mysql.HotelRepository;
import com.project3.tpbooking.repository.mysql.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private UserRepository userRepository;

    public CommentResponse save(CommentRequest request){
        Hotel hotel = hotelRepository.getById(request.getHotelId());
        User user = userRepository.getById(request.getUserId());
        Comment comment = new Comment();
        comment.setHotel(hotel);
        comment.setUser(user);
        comment.setContent(request.getContent());
        comment.setTitle(request.getTitle());
        comment.setTime(new Date());

        Comment rs = commentRepository.save(comment);

        return convert(rs);
    }

    public List<CommentResponse> getListComment(String id){
        return commentRepository.getAllByHotelId(id).stream().map(e->convert(e)).collect(Collectors.toList());
    }

    public CommentResponse convert(Comment comment){
        User user = new User()
                .setId(comment.getUser().getId())
                .setUserName(comment.getUser().getUserName())
                .setAvatar(comment.getUser().getAvatar());

        return new CommentResponse()
                .setId(comment.getId())
                .setUser(user)
                .setHotelId(comment.getHotel().getId())
                .setTitle(comment.getTitle())
                .setContent(comment.getContent())
                .setTime(comment.getTime());
    }
}
