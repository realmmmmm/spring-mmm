package com.mvc.io.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *  转发 和 重定向
 */
@Controller
public class RedirectController {

    // 转发
    @GetMapping("/transpond")
    public String transpond(Model model){
        model.addAttribute("msg","转发的");
        return "/home/transpond";
    }

    // 重定向
    @GetMapping("/redirect")
    public String redirect(){
        return "redirect:redirect2";
    }

    // 重定向2
    @GetMapping("/redirect2")
    public String redirect2(){
        return "/home/redirect";
    }

}
