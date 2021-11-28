package com.project3.tpbooking.repository.mysql;

import com.project3.tpbooking.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Integer> {
    Partner findByUserName(String username);
}
