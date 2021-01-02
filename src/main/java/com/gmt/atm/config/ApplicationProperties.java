package com.gmt.atm.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
@Getter
@Setter
public class ApplicationProperties {

    @Value("${url.api.country}")
    private String urlApiCountry;

    @Value("${url.api.convert}")
    private String urlApiConvert;

    @Value("${url.api.atm}")
    private String urlApiAtm;

    @Value("${api.access.key}")
    private String apiAccessKey;

}
