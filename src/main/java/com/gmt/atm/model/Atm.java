package com.gmt.atm.model;

import lombok.Data;

@Data
public class Atm {

    private String type;
    private String[] functionality;
    private int distance;
    private Address address;

}
