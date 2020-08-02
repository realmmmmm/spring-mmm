package com;

import myRule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;


@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient //服务发现~
//@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = MyRule.class) //开启负载均衡,并指定自定义的规则
public class SpringCloudConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsumerApplication.class, args);
    }
}
