package com.project3.tpbooking.document;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ReviewScore {
    private float score;
    private int count;
    private float clean;
    private float convenient;
    private float location;
    private float service;
    private float worthTheMoney;
}
