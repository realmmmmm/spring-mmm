package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 配置文件在远程git仓库，访问配置文件地址：http://xxx:3344/master/config-eureka-dev.yml
 */
@SpringBootApplication
@EnableEurekaClient
//扫描所有自己的包,让所有注解也能生效
@ComponentScan("com.modules")
public class SpringCloudConfig3355Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfig3355Application.class, args);
    }
}
