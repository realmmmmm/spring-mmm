package com.spring.one.config.component;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


public class LocaleResoverLanguage implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获取自定义请求头信息
        String language = httpServletRequest.getParameter("l");
        //获取浏览器上的区域信息
        Locale locale = httpServletRequest.getLocale();
        //zh_CN en_US
        if(!StringUtils.isEmpty(language)){
            String languageCode = "";
            String countryCode = language;

            if("CN".equals(language)){
                languageCode = "zh";
            }else if ("US".equals(language)){
                languageCode="en";
            }
            //接收第1个参数为：语言代码， 国家代码
            return  new Locale(languageCode, countryCode);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
