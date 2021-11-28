package com.project3.tpbooking.controller;

import com.project3.tpbooking.data.model.DfResponse;
import com.project3.tpbooking.service.EsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    private final EsService esService;


    public HotelController(EsService esService) {
        this.esService = esService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getHotelById(@PathVariable(name = "id") String id){
        return DfResponse.okEntity(esService.findHotelById(id));
    }
}
