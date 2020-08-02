package com.modules.controller;

import com.modules.pojo.Dept;
import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 *  使用Rest进行两个微服务直接的调用
 */
@RestController
public class DeptController {

    /**
     * 消费者不应该有Service层
     * RestTemplate 直接调用
     * restTemplate.getForObject(...)
     * restTemplate.postForObject(...)
     */
    @Autowired
    private RestTemplate restTemplate;


    // Ribbon 客户端负债均衡，
    // 测试需要 开启eureks服务，3个消费者服务8001、8002、8003 服务。请求连接，分别请求不同数据库
    private static final String REST_URL_PREFIX = "http://PROVIDER-DEPT";

    /**
     * restTemplate的使用，参数说明: 地址，请求参数类型，返回数据类型
     * restTemplate.postForObject(REST_URL_PREFIX + "/product/add", product, Boolean.class);
     * restTemplate.getForObject(REST_URL_PREFIX + "/product/get/" + id, Product.class);
     * restTemplate.getForObject(REST_URL_PREFIX + "/product/list", List.class);
     * @return
     */
    @RequestMapping(value = "/consumer/dept")
    public List<Dept> add() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }




}
