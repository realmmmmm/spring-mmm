package com.spring.asyn.modules;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定时任务 @Scheduled
 */
@RestController
public class ScheduledConst {

    /*
    * 定时任务
    * 有 cron 属性来指定 cron 表达式：秒 分 时 日 月 几
    * cron表达式
    * 在线生成cron表达式 http://cron.qqe2.com/
    * */

    @GetMapping("/scheduled")
    public String  doScheduled(){

       // doScheduledGo();

        return "succeed";
    }

    //@Scheduled(cron = "0,10,20,30,40,50 * * * * ? ")
    private void doScheduledGo(){
        System.out.println("定时任务1111");
    }

}
