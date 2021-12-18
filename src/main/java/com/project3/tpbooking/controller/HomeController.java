package com.project3.tpbooking.controller;

import com.project3.tpbooking.data.model.DfResponse;
import com.project3.tpbooking.data.model.request.HomeSearchRequest;
import com.project3.tpbooking.service.EsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class HomeController {
    private final EsService esService;

    public HomeController(EsService esService) {
        this.esService = esService;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<?> home(){
        return DfResponse.okEntity(esService.home());
    }

    @PostMapping({"/search"})
    public ResponseEntity<?> search(@RequestBody HomeSearchRequest request){
        return DfResponse.okEntity(esService.search(request));
    }
}