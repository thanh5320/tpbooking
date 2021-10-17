package com.project3.tpbooking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name="room_img")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_img_id")
    private Integer id;

    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name="room_id", nullable=false)
    private Room room;
}