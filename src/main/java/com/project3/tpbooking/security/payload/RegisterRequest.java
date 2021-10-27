package com.project3.tpbooking.security.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String userName;

    private String password;

    private String fullName;

    private String email;

    private String phoneNumber;

    private Date dob;

    private Integer gender;

    private String role;
}
