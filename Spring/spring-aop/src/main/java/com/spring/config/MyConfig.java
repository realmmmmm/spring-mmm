package com.spring.config;


import com.spring.io.entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.spring")
//@Import(其他的.class)
public class MyConfig {

    @Bean
    public User getUser(){
        return new User();
    }
}
