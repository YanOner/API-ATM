package com.gmt.atm.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Country {

    private String code;

    private String name;

}
