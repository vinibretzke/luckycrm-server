package com.lbss.luckycrmserver.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PwEncoder {
    @Bean
    public PwEncoder passwordEncoder() {
        return new PwEncoder();
    }
}