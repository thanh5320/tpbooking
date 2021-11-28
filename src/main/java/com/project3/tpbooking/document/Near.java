package com.project3.tpbooking.document;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Near {
    private String name;
    private int distance;
}
