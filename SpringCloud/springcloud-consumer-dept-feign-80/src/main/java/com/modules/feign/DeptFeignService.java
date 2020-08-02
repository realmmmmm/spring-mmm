package com.modules.feign;

import com.modules.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// @FeignClient:微服务客户端注解, value:指定微服务的名字,这样就可以使Feign客户端直接找到对应的微服务  fallbackFactory 熔断降级
@FeignClient(value = "PROVIDER-DEPT-HYSTRIX",fallbackFactory = DeptClientServiceFallBackFactory.class)
public interface DeptFeignService {

    @GetMapping("/dept/list")
    List<Dept> gatList();

    @GetMapping("/dept/one/{id}")
    Dept gatOne(@PathVariable("id") Integer id);

}
