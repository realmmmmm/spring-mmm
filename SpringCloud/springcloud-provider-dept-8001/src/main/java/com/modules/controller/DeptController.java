package com.modules.controller;

import com.modules.pojo.Dept;
import com.modules.service.DeptService;
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

    @GetMapping("/dept/one/{id}")
    public Dept getDept(@PathVariable("id") Integer tid){
        //System.out.println(tid);
        Dept all = deptService.getDept(tid);
        return all;
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
