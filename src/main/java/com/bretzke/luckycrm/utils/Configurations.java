package com.bretzke.luckycrm.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Configurations {
    @Bean
    public PasswordEnconder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
