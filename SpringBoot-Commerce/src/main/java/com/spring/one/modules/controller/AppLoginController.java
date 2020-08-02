package com.spring.one.modules.controller;


import com.spring.one.modules.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class AppLoginController {

    @Autowired
    UserService userService;

    //日志记录器
    private Logger logger = LoggerFactory.getLogger(getClass());
    

    @PostMapping("/doLogin")
    public String doLogin(HttpSession session, String username, String password, Map<String,String> map){

        String pass=userService.selectPassword(username);
        if(password.equals(pass)){
            session.setAttribute("LoginState",username);
            // 重定向  : 名字 在默认视图解析器里配置
            return "redirect:home";
        }
        map.put("msg","用户名或密码错误！");
        System.out.println("登录失败");

        //打印日志 级别
        logger.trace("登录失败+trace");
        logger.debug("登录失败+debug");
        logger.info("登录失败+info");
        logger.warn("登录失败+warn");
        logger.error("登录失败+error");

        return "main/login";
    }

    @GetMapping("/doQuit")
    public String doQuit(HttpSession session){
        session.removeAttribute("LoginState");
        session.invalidate();
        return "redirect:login";
    }

}
