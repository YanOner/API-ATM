package com.gmt.atm.external;

import com.gmt.atm.model.Atm;
import com.gmt.atm.model.Country;

import java.util.List;

public interface RestExternalService {

    List<Country> listAllCountries();

    List<Atm> listAllAtms();

    Double convert(String source, String target);

}
