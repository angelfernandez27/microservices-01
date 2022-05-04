package com.microservice.usuarioservice.setting;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    //Agregamos el método resttemplate a la config de spring
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
