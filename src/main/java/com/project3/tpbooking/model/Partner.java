package com.project3.tpbooking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name="partner")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Partner {
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

    @Column(name = "active")
    private Boolean active;

    @Column(name = "avatar")
    private String avatar;

}
