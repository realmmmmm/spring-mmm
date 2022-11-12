# SpringCloud
SpringCloud构建分布式系统，运用了Eureka、Ribbon、Feign、Hystrix、Zuul、Config、Bus

=======
# 基于 SpringCloud 搭建微服务系统
工程介绍 <br>
父工程： <br>
  SpringCloud <br>
子工程  <br> 
  springcloud-consumer-dept-80      （Rest构建客户端） <br>
  springcloud-eureka-7001           （Eureka注册中心集群搭建） <br>
  springcloud-eureka-7002           （Eureka注册中心集群搭建） <br>
  springcloud-eureka-7003           （Eureka注册中心集群搭建） <br> 
  springcloud-provider-dept-8002    （服务端集群搭建，Ribbon负载均衡）<br>
  springcloud-provider-dept-8003    （服务端集群搭建，Ribbon负载均衡）<br>
  springcloud-consumer-dept-feign-80（Feign客户端接口调用）<br>
  springcloud-provider-dept–hystrix-8001     （服务端Hystrix熔断处理集群）<br>
  springcloud-provider-dept–hystrix-8002     （服务端Hystrix熔断处理集群）<br>
  springcloud-consumer-hystrix-dashboard-9001（hystrix-dashboard服务熔断监控）<br>
  springcloud-zuul-9527             （Zuul网关路由，拦截器）<br>
  springcloud-config-server-3344    （Config配置中心服务）  <br>
  springcloud-config-client-3355    （Config客户端，获取Git仓库配置文件）<br>
  springcloud-config-dept-feign-80  （Config + Feign 客户端） <br>
  springcloud-config-eureka-7001    （Config + Eureka 注册中心） <br>
  springcloud-config-dept-hystrix-8001 （Config + Hystrix + Bus 服务端）<br>
  springcloud-test                             <br>
  
 ## 数据库
 分别导入 bill.sql、 bill2.sql、 bill3.sql，方便测试客户端负载均衡。
 
 ## Eureka 的使用
``` bash
1.导包
  <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-eureka-server</artifactId>
      <version>1.4.6.RELEASE</version>
  </dependency>
2.启动类开启注解 @EnableEurekaServer
3.配置文件修改配置，集群搭建通过配置文件修改
```

 ## Ribbon 的使用
``` bash
1.导包
  <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-ribbon</artifactId>
      <version>1.4.6.RELEASE</version>
  </dependency>
2.启动类开启注解 @RibbonClient
3.配置类，配置负载均衡实现RestTemplate，加上@LoadBalanced注解
```

 ## Feign 的使用
``` bash
1.导包
  <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-feign</artifactId>
      <version>1.4.6.RELEASE</version>
  </dependency>
2.启动类开启注解 @EnableFeignClients
3.创建接口类，作为调用其它工程接口，加上@FeignClient注解，配置接口之间的调用
```

 ## Hystrix 的使用
``` bash
1.导包
  <!--监控-->
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-actuator</artifactId>
  </dependency>
  <!--导入Hystrix依赖-->
  <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-hystrix</artifactId>
      <version>1.4.6.RELEASE</version>
  </dependency>
2.配置文件，被监控服务上添加暴露端点
3.启动类，加上@EnableCircuitBreaker注解
4.根据 @HystrixCommand 完成熔断类处理。
5.Hystrix的监控搭建，需要导入
  <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-hystrix-dashboard</artifactId>
      <version>1.4.6.RELEASE</version>
  </dependency>
  启动类开启@EnableHystrixDashboard
  访问熔断监控页面：***/hystrix
```

 ## Zuul 的使用
``` bash
1.导包
 <dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zuul</artifactId>
    <version>1.4.6.RELEASE</version>
 </dependency>
2.启动类开启注解 @EnableZuulProxy
3.配置文件，进行配置路由网关信息
4.拦截器，创建类继承ZuulFilter类，重新里面发方法
```

 ## SpringCloudConfig 的使用
``` bash
Config 服务端的配置：
1.导包
 <dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
    <version>2.1.1.RELEASE</version>
 </dependency>
2.启动类，开启@EnableConfigServer
3.配置文件，配置要远程访问git仓库地址，或者svn地址
4.通过本机可以访问远程仓库上的配置文件，本项目，使用gitee
Config 客户端的配置：
1.导包
 <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-config</artifactId>
      <version>2.1.1.RELEASE</version>
 </dependency>
2.配置文件，调用Config 服务端，访问想要的配置文件
```

 ## SpringCloudBus 的使用
``` bash
1.导包
  <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-bus-amqp</artifactId>
      <version>2.1.1.RELEASE</version>
  </dependency>
2.本地需要安装rabbitmq
3.配置文件，连接rabbitmq，和要开放的暴露端点
4.给要刷新配置信息加上@RefreshScope，Druid需要在方法上加
5.如果远程修改仓库文件，发送POST请求，http://xxx:80/actuator/bus-refresh，不需要重启，更改配置文件信息
```

