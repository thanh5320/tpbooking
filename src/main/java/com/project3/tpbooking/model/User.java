package com.project3.tpbooking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


import javax.persistence.*;
import java.util.Date;

@Data
@Table(name="user")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name="username")
    private String userName;

    @Column(name="password")
    private String password;

    @Column(name="fullname")
    private String fullName;

    @Column(name="email")
    private String email;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="dob")
    private Date dob;

    @Column(name="gender")
    private Integer gender;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "role")
    private ERole role;

}
