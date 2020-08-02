package com;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;


@MapperScan("com.modules.dao")
@SpringBootApplication
@EnableEurekaClient
// 添加对熔断的支持注解
@EnableCircuitBreaker
public class SpringCloudProvider8001Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProvider8001Application.class, args);
    }

}
