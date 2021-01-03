package com.gmt.atm.controller;

import com.gmt.atm.model.Atm;
import com.gmt.atm.model.Country;
import com.gmt.atm.service.AtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/atm")
public class AtmController {

    @Autowired
    private AtmService atmService;

    @GetMapping("/countries")
    public List<Country> listCountries(){
        return atmService.listAllCountries();
    }

    @GetMapping("/list")
    public List<Atm> listAtms(){
        return atmService.listAllAtms();
    }

    @GetMapping("/convert")
    public Double convert(
            @RequestParam String source,
            @RequestParam String target
    ){
        return atmService.convert(source, target);
    }

}
