package com.project3.tpbooking.repository.mysql;

import com.project3.tpbooking.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    @Query(value = "SELECT * FROM reservation WHERE user_id = ?1", nativeQuery = true)
    List<Reservation> findByUser(Integer userId);

    @Modifying
    @Transactional
    @Query(value = "update reservation r set r.status = ?2 where r.reservation_id=?1", nativeQuery = true)
    int updateStatus(Integer id, Integer status);
}
