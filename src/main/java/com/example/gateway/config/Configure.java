package com.example.gateway.config;

import com.example.gateway.filter.AccessFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configure {


    @Bean
    public AccessFilter getAccessFilter(){
        return new AccessFilter();
    }

}