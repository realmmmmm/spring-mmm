package com;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;


@SpringBootApplication
@EnableEurekaClient
// 开启熔断监控  访问页面： ***/hystrix
@EnableHystrixDashboard
//@EnableTurbine
public class SpringCloud9001Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloud9001Application.class, args);
    }

}
