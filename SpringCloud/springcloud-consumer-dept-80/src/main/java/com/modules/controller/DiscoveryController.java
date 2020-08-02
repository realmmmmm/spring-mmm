package com.modules.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 注册进来的微服务，获取一些消息（团队开发会用到）
 */
@RestController
public class DiscoveryController {

    //获取一些配置的信息，得到具体的微服务！
    @Autowired
    private DiscoveryClient client;

    //注册进来的微服务~，获取一些消息~
    @GetMapping("/consumer/discovery")
    public Object discovery() {
        //获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery=>services:" + services);
        //得到一个具体的微服务信息,通过具体的微服务id，applicaioinName；  查看 消费者的信息
        List<ServiceInstance> instances = client.getInstances("provider-dept");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t" + // 主机名称
                            instance.getPort() + "\t" + // 端口号
                            instance.getUri() + "\t" + // uri
                            instance.getServiceId() // 服务id
            );
        }
        return this.client;
    }

}
