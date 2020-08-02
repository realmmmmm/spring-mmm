package com.mvc.io.controller;

import com.mvc.io.entities.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterceptorController {

    @GetMapping("/admin/home")
    public String home(){
        return "新年好";
    }


    @GetMapping("/admin/add")
    public String add(){
        return "add";
    }

}
