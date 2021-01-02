package com.gmt.atm.service;

import com.gmt.atm.model.Atm;
import com.gmt.atm.model.Country;

import java.util.List;

public interface AtmService {

    List<Country> listAllCountries();

    List<Atm> listAllAtms();

    Double convert(String source, String target);

}
