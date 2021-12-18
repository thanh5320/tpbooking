package com.project3.tpbooking.service;

import com.project3.tpbooking.model.Partner;
import com.project3.tpbooking.repository.mysql.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartnerService {
    @Autowired
    private PartnerRepository partnerRepository;

    public Partner save(Partner partner){
        return partnerRepository.save(partner);
    }
}
