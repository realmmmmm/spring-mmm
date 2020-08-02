package com.spring.asyn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


//开启定时任务
@EnableScheduling
//开启异步处理
@EnableAsync
@SpringBootApplication
public class AsynApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsynApplication.class, args);
    }

}
