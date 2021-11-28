package com.project3.tpbooking.document;


import com.project3.tpbooking.document.Near;
import com.project3.tpbooking.document.ReviewScore;
import com.project3.tpbooking.document.Room;
import com.project3.tpbooking.document.Service;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Hotel {
    private String link;
    private String id;
    private String name;
    private List<String> imgs;
    private String city;
    private String address;
    private String description;
    private ReviewScore reviewScore;
    private List<Room> rooms;
    private List<Near> nears;
    private List<Service> services;
}
