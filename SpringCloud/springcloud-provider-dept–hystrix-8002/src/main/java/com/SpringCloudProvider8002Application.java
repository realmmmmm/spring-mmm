package com;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;


@MapperScan("com.modules.dao")
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class SpringCloudProvider8002Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProvider8002Application.class, args);
    }

//    //增加一个 Servlet
//    @Bean
//    public ServletRegistrationBean hystrixMetricsStreamServlet(){
//        ServletRegistrationBean registrationBean = new ServletRegistrationBean<>(new HystrixMetricsStreamServlet());
//        //访问该页面就是监控页面
//        registrationBean.addUrlMappings("/actuator/hystrix.stream");
//        return registrationBean;
//    }
}
