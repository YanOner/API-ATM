package com.gmt.atm.model;

import lombok.Data;

import java.util.Map;

@Data
public class Address {

    private String street;
    private String housenumber;
    private String postalcode;
    private String city;
    private Map<String, Double> geoLocation;

}
