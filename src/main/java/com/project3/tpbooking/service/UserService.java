package com.project3.tpbooking.service;

import com.project3.tpbooking.model.User;
import com.project3.tpbooking.repository.mysql.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User findByUsername(String username){
        return userRepository.findByUserName(username);
    }
}
