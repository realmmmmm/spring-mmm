package com.modules.controller;

import com.modules.pojo.Dept;
import com.modules.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
