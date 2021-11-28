package com.project3.tpbooking.document;


import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Service {
    private String name;
    private List<String> service;
}
