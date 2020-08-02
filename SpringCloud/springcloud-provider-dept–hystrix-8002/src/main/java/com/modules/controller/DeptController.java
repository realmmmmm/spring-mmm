package com.modules.controller;

import com.modules.pojo.Dept;
import com.modules.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/dept/list")
    public List<Dept> getDeptList(){
        List<Dept> all = deptService.getAll();
        System.out.println(all);
        return all;
    }

    @HystrixCommand(fallbackMethod = "hystrixGet")
    @GetMapping("/dept/one/{id}")
    public Dept getDept(@PathVariable("id") Integer tid){
        //System.out.println(tid);
        Dept all = deptService.getDept(tid);
        if (all==null){
            throw new RuntimeException("这个id=>"+tid+",不存在该用户，或信息无法找到~");
        }
        return all;
    }

    //根据id查询备选方案 (熔断)
    public Dept hystrixGet(@PathVariable("id") Integer tid){
        //Long i = (long) id;
        return new Dept().setId((long) tid)
                .setDname("这个id=>"+tid+",没有对应的信息,null---@Hystrix~")
                .setDbSource("在MySQL中没有这个数据库");
    }


    @PostMapping("/dept/add")
    public Boolean addDept(){
        Dept dept = new Dept();
        dept.setDname("aaa");
        dept.setDbSource("01");
        deptService.addDept(dept);
        return true;
    }
}
