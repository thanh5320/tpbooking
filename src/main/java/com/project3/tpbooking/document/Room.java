package com.project3.tpbooking.document;


import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Room {
    private  String id;
    private String name;
    private List<String> imgs;
    private List<String> utils;
    private List<String> benefit;
    private int adults;
    private int children;
    private int cost;
}
