package com.project3.tpbooking.security.payload;

import com.project3.tpbooking.model.ERole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    private String token;
    private int id;
    private String username;
    private String roles;
}
