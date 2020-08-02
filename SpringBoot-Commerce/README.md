## spring-boot 项目
使用springboot2.x 搭建的帐单管理系统

## 核心依赖

``` bash

  Spring Boot 2.2.1.RELEASE 
  Mybatis 2.1.1
  alibaba连接池 1.1.1
  thymeleaf 使用了thymeleaf来显示前端页面
  
```

## 软件需求
- JDK1.7+
- MySQL5.5+
- Tomcat7.0+
- Maven3.0+

## 数据库
  在sql文件下，我本地使用Mysql

## 事务管理
  @Transaction，在TransactionController下使用到
  在启动器加上@EnableTransactionManagement
 
## thymeleaf 模板引擎
导入 Thymeleaf 的名称空间<br>
在 html 页面加上以下名称空间, 使用 Thymeleaf 时就有语法提示。

## spring Boot 热部署依赖
``` bash
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
    </dependency>
```

## 多语言国际化
 在类路径下i18n  目录存放配置文件
