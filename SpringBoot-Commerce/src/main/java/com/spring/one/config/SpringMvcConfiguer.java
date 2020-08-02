package com.spring.one.config;

import com.spring.one.config.component.LocaleResoverLanguage;
import com.spring.one.config.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class SpringMvcConfiguer implements WebMvcConfigurer{

    /** 默认显示首页 */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("main/index");
        registry.addViewController("/index.html").setViewName("main/login");
        registry.addViewController("/home").setViewName("main/index");
        registry.addViewController("/login.html").setViewName("main/login");
        registry.addViewController("/login").setViewName("main/login");
    }

    /** 拦截器 */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login","/login.html","/doLogin")
                .excludePathPatterns("/css/**","/img/**","/js/**");
    }

    /* 区域解析器 */
    @Bean
    public LocaleResolver localeResolver(){
        return new LocaleResoverLanguage();
    }

}
