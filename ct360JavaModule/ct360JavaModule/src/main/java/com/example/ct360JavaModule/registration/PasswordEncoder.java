package com.example.ct360JavaModule.registration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Configuration
public class PasswordEncoder {

    @Bean
    public BCryptPasswordEncoder bcpe(){

        return new BCryptPasswordEncoder();
    }
}
