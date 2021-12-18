package com.project3.tpbooking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Table(name="room")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class Room {
    @Id
    @Column(name = "room_id")
    private String id;

    @ManyToOne
    @JoinColumn(name="hotel_id", nullable=false)
    private Hotel hotel;

    @Column(name = "nor_available")
    private Integer norAvailable;

    @Column(name = "nor")
    private Integer nor;

    @Column(name = "price")
    private double price;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private Integer type;

    @Column(name="description")
    private String description;

    @Column(name = "active")
    private Boolean active;

}
