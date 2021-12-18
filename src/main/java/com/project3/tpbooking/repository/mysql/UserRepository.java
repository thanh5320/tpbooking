package com.project3.tpbooking.repository.mysql;

import com.project3.tpbooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String username);

    boolean existsByUserName(String username);

    User getOne(Integer id);
}
