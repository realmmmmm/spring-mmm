package com.modules.controller;

import com.modules.feign.DeptFeignService;
import com.modules.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *  使用Feigh,实现负载均衡
 *  我们调用自己写的接口，
 *  feign 这个包下是调用消费者的接口
 */
@RestController
public class DeptController {

    @Autowired
    private DeptFeignService deptFeignService = null;


    @GetMapping("/consumer/dept/list")
    public List<Dept> add(Dept dept) {
        return this.deptFeignService.gatList();
    }

    @GetMapping("/consumer/dept/one/{id}")
    public Dept get(@PathVariable("id") Integer id) {
        return this.deptFeignService.gatOne(id);
    }



}
