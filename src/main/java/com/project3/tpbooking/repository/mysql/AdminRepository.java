package com.project3.tpbooking.repository.mysql;

import com.project3.tpbooking.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findByUserName(String username);
}
