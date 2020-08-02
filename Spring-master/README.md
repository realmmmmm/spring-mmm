## Spring项目，基本操作者练习
分为3个小项目，Spring-aop、Spring-mvc、Spring-mybatis

=======
# Spring-aop 项目
搭建Spring工程 <br>
导入Spring包，使用注解开发，AOP的练习
## AOP（面向切面编程）
``` bash
常用名词：
切面（ASPECT）：横切关注点 被模块化 的特殊对象。即，它是一个类。
通知（Advice）：切面必须要完成的工作。即，它是类中的一个方法。
目标（Target）：被通知对象。
代理（Proxy）：向目标对象应用通知之后创建的对象。
切入点（PointCut）：切面通知 执行的 “地点”的定义。
连接点（JointPoint）：与切入点匹配的执行点。

需要导包：
<dependency>
   <groupId>org.aspectj</groupId>
   <artifactId>aspectjweaver</artifactId>
   <version>1.9.4</version>
</dependency>
```

# Spring-mybatis 项目
搭建Mybatis工程 <br>
使用注解开发，连接数据库，对数据库增删操作，分别模糊查询、分页查询、一对多、多对一、动态SQL、二级缓存。
## 需要导包
``` bash
<!--mysqlq驱动-->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.12</version>
</dependency>
<!--mybatis-->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.5</version>
</dependency>
<!-- 工具类 lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.10</version>
    <scope>provided</scope>
</dependency>
<dependency>
    <groupId>org.mybatis.caches</groupId>
    <artifactId>mybatis-ehcache</artifactId>
    <version>1.2.1</version>
</dependency>
```
## 配置
``` bash
1. 导入数据库，bill.sql
2. 配置文件：  mybatis-config.xml
3. 日志配置文件：log4j.properties
4. 缓存配置文件：ehcache.xml
5. 数据库连接：  db.properties
```
## Mybatis核心配置文件
``` bash
  configuration（配置）
  properties（属性）
  settings（设置）
  typeAliases（类型别名）
  typeHandlers（类型处理器）
  objectFactory（对象工厂）
  plugins（插件）
      environments（环境配置）
        environment（环境变量）
        transactionManager（事务管理器）
  dataSource（数据源）
  databaseIdProvider（数据库厂商标识）
  mappers（映射器）
```
## Mybatis详细执行流程：
``` bash
1.Resource获取全局配置文件
2.实例化SqlsessionFactoryBuilde
3.解析配置文件流XMLCondigBuilder
4.Configration所有的配置信息
5.SqlSessionFactory实例化
6.trasactional事务管理
7.创建executor执行器
8.创建SqlSession
9.实现CRUD
10.查看是否执行成功
11.提交事务
12.关闭
```

## Lombok的使用
``` bash
引入包：
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
  <version>1.18.12</version>
</dependency>
@Data: 无参构造，get，set，toString，hashCode
在实体类上加注解，这样无需手动写get，set ...方法
```
## 缓存的使用
``` bash
1.一级缓存：
默认开启，只在一次sqlseesion中有效

2. 二级缓存
开启全局缓存：（配置文件里添加）
<setting name="cacheEnabled" value="true"/>
使用缓存：
<cache/>

3.自定义缓存-ehcache
需要导入包：
<dependency>
    <groupId>org.mybatis.caches</groupId>
    <artifactId>mybatis-ehcache</artifactId>
    <version>1.2.0</version>
</dependency>
配置文件: ehcache.xml
```

# Spring-mvc 项目
搭建Spring-MVC工程 <br>
使用注解开发，RestFul接口，转发和重定向，JSON数据处理，拦截器和文件上传下载处理。
## 需要导包
``` bash
<!--spring -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.2.5.RELEASE</version>
</dependency>
<!-- jackson 的 JSON处理 -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.9.8</version>
</dependency>
<!-- fastjson 的 JSON处理 -->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.72</version>
</dependency>
<!-- 拦截器需要 https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.1</version>
</dependency>
<!--文件上传-->
<dependency>
    <groupId>commons-fileupload</groupId>
    <artifactId>commons-fileupload</artifactId>
    <version>1.3.3</version>
</dependency>
<!--servlet-api导入高版本的-->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.1</version>
</dependency>
```
实现功能：<br/>
转发和重定向，JSON数据处理，拦截器和文件上传下载处理。


