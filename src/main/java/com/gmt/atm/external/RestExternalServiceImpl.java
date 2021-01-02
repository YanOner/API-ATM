package com.gmt.atm.external;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmt.atm.config.ApplicationProperties;
import com.gmt.atm.model.Atm;
import com.gmt.atm.model.Country;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class RestExternalServiceImpl implements RestExternalService {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Override
    public List<Country> listAllCountries() {
        RestTemplate restTemplate = new RestTemplate();

        String url
                = applicationProperties.getUrlApiCountry()
                    + applicationProperties.getApiAccessKey();

        Map<String, Object> response
                = restTemplate.getForObject(url, Map.class);

        log.info("url: "+url);

        Map<String, String> map =
                (Map<String, String>) response.get("currencies");

        List<Country> list = new ArrayList<>();
        map.forEach((k, v) -> {
            list.add(
                    Country.builder()
                    .code(k)
                    .name(v)
                    .build()
            );
        });

        log.info("list countries: "+list);

        return list;
    }

    @Override
    public List<Atm> listAllAtms() {
        RestTemplate restTemplate = new RestTemplate();

        String url
                = applicationProperties.getUrlApiAtm();

        String response
                = restTemplate.getForObject(url, String.class);

        log.info("url: "+url);

        String json = response.substring(5);

        log.info("json: "+json.substring(0, 100));

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            return Arrays.asList(objectMapper.readValue(json, Atm[].class));
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public Double convert(String source, String target) {
        RestTemplate restTemplate = new RestTemplate();

        String url
                = applicationProperties.getUrlApiConvert()
                + applicationProperties.getApiAccessKey()
                + "&source=" + source
                + "&currencies=" + target;

        Map<String, Object> response
                = restTemplate.getForObject(url, Map.class);

        log.info("url: "+url);

        Map<String, Double> map =
                (Map<String, Double>) response.get("quotes");

        log.info("map: "+map);

        return (map.get(source + target));
    }

}
