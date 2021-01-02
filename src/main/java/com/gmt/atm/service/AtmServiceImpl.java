package com.gmt.atm.service;

import com.gmt.atm.external.RestExternalService;
import com.gmt.atm.model.Atm;
import com.gmt.atm.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AtmServiceImpl implements AtmService{

    @Autowired
    private RestExternalService restExternalService;

    @Override
    public List<Country> listAllCountries() {
        return restExternalService.listAllCountries();
    }

    @Override
    public List<Atm> listAllAtms() {
        return restExternalService.listAllAtms();
    }

    @Override
    public Double convert(String source, String target) {
        return restExternalService.convert(source, target);
    }
}
