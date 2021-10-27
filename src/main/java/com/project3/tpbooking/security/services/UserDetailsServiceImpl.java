package com.project3.tpbooking.security.services;

import com.project3.tpbooking.model.ERole;
import com.project3.tpbooking.model.User;
import com.project3.tpbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);

        if (user != null) {
            String password = user.getPassword();
            ERole role = user.getRole();
            int id = user.getId();
            return UserDetailsImpl.build(username, password, id, role);
        }

            throw new UsernameNotFoundException("User Not Found with username: " + username);

    }
}
