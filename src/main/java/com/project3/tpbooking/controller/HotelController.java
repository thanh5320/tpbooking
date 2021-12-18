package com.project3.tpbooking.controller;

import com.project3.tpbooking.data.model.DfResponse;
import com.project3.tpbooking.data.model.request.CommentRequest;
import com.project3.tpbooking.data.model.response.CommentResponse;
import com.project3.tpbooking.service.CommentService;
import com.project3.tpbooking.service.EsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    private final EsService esService;

    @Autowired
    private CommentService commentService;

    public HotelController(EsService esService) {
        this.esService = esService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getHotelById(@PathVariable(name = "id") String id){
        return DfResponse.okEntity(esService.findHotelById(id));
    }

    @PostMapping("/comment/add")
    public ResponseEntity<?> addComment(@RequestBody CommentRequest request){
        return DfResponse.okEntity(commentService.save(request));
    }

    @GetMapping("/comment/{id}")
    public ResponseEntity<?> getListComment(@PathVariable(name = "id") String id){
        return DfResponse.okEntity(commentService.getListComment(id));
    }
}
