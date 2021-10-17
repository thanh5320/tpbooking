package com.project3.tpbooking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name="hotel")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "place")
    private String place;

    @Column(name = "star")
    private Integer star;

    @Column(name="email")
    private String email;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name="partner_id", nullable=false)
    private Partner partner;

    @ManyToOne
    @JoinColumn(name="province_id", nullable=false)
    private Province province;

    @Column(name = "active")
    private Boolean active;

}
