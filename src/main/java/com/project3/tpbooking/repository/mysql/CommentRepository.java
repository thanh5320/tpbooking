package com.project3.tpbooking.repository.mysql;

import com.project3.tpbooking.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query(value = "select * from comment where hotel_id = ?1", nativeQuery = true)
    List<Comment> getAllByHotelId(String hotelId);
}
