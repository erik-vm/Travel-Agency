package com.pilgrims.travelagency.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Base64;

/**
 * Configuration for security
 *
 * @author Ott Pikk
 */
@Configuration
public class SecurityConfigurations  {

    @Bean
    public Base64.Encoder base64Encoder() {return Base64.getEncoder();}


}
