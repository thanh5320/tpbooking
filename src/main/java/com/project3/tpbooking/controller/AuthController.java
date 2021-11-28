package com.project3.tpbooking.controller;

import com.project3.tpbooking.model.ERole;
import com.project3.tpbooking.model.User;
import com.project3.tpbooking.repository.mysql.UserRepository;
import com.project3.tpbooking.security.jwt.JwtUtils;
import com.project3.tpbooking.security.payload.JwtResponse;
import com.project3.tpbooking.security.payload.LoginRequest;
import com.project3.tpbooking.security.payload.MessageResponse;
import com.project3.tpbooking.security.payload.RegisterRequest;
import com.project3.tpbooking.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String role = userDetails.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList()).get(0);
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), role));

    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest){
        if(userRepository.existsByUserName(registerRequest.getUserName())){
            return ResponseEntity.badRequest().body(new MessageResponse("Duplicate username"));

        }

        ERole role;

        switch (registerRequest.getRole()){
            case "admin":
                role = ERole.ROLE_ADMIN;
                break;
            case "partner":
                role = ERole.ROLE_PARTNER;
                break;
            case "user":
                role = ERole.ROLE_USER;
                break;
            default:
                role = ERole.ROLE_USER;
        }

        User user = new User(0,registerRequest.getUserName(),
                encoder.encode(registerRequest.getPassword()),
                registerRequest.getFullName(),
                registerRequest.getEmail(),
                registerRequest.getPhoneNumber(),
                registerRequest.getDob(),
                registerRequest.getGender(),
                true,
                "",
                role);

        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("Register successfully"));


    }

    @GetMapping("/test")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String test() {
        return "test.";
    }
}
