package com.spring.asyn.modules;



import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//异步的处理  @Async注解  进行异步处理
@RestController
public class AsynConst {

    @Async
    @GetMapping("/asyn")
    public String doAsynThing(){

        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("5秒后打印出来了");
        return "succeed";
    }


}
