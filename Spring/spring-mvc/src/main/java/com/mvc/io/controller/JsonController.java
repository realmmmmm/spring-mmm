package com.mvc.io.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mvc.config.JsonResult;
import com.mvc.io.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  Json 处理
 *    jackson
 *    FastJson
 */
@RestController
public class JsonController {

    @GetMapping("/json/user")
    public String user(Model model){
        User user = new User("王宝强", 3, "男");
        return user.toString();
    }

    // jackson 将对象解析成为json格式
    @RequestMapping("/jackson")
    public String jackson() throws JsonProcessingException {
        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        User user = new User("人物1", 3, "男");
        //将我们的对象解析成为json格式  如果是list对象也是这个方法执行。
        String str = mapper.writeValueAsString(user);
        return str;
    }

    //输出时间对象  默认是时间戳形式返回，自定义形式
    @GetMapping("/jackson2")
    public String jackson2() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //自定义日期格式对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //指定日期格式
        mapper.setDateFormat(sdf);
        Date date = new Date();
        String str = mapper.writeValueAsString(date);
        return str;
    }



}
