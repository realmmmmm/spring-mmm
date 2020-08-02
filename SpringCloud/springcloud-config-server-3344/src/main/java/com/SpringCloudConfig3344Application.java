package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 访问： http://xxxx:3344/application-dev.yml 可以访问到远程的git
 */
@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfig3344Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfig3344Application.class, args);
    }
}
