package com.note;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.note.modules.dao")
@SpringBootApplication
public class AppSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppSpringApplication.class,args);
    }
}
