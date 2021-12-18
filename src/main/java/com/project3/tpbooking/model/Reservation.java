package com.project3.tpbooking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name="reservation")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="room_id", nullable=false)
    private Room room;

    @Column(name = "date_checkin")
    private Date dateCheckin;

    @Column(name = "date_checkout")
    private Date dateCheckout;

    @Column(name = "adults")
    private Integer adults;

    @Column(name = "children")
    private Integer children;

    @Column(name = "pay") // 1 đã thanh toán, 0 chưa thanh toán
    private Integer pay;

    @Column(name = "status") // 1 đã đặt, 2 đã đến khách sạn, 0 đã hủy
    private Integer status;
}
