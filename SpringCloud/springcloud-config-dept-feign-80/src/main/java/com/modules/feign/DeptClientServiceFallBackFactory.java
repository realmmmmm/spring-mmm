package com.modules.feign;

import com.modules.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *  客户端 - 熔断降级
 *  步骤，配置文件修改
 *        @FeignClient 返回处理类，这个类重写create方法
 */
@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory {

    @Override
    public Object create(Throwable throwable) {
        return new DeptFeignService() {
            @Override
            public List<Dept> gatList() {
                return null;
            }


            @Override
            public Dept gatOne(Integer id) {
                return new Dept()
                        .setId((long) id)
                        .setDname("id=>" + id + "没有对应的信息，客户端提供了降级的信息，这个服务现在已经被关闭")
                        .setDbSource("没有数据~");
            }
        };
    }
}
