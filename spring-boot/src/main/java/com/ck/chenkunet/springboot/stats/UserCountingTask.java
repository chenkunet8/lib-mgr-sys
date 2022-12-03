package com.ck.chenkunet.springboot.stats;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class UserCountingTask {

    /**
     * 定时给目前所有的websocket链接发送人数消息
     */
    @Scheduled(cron = "0/5 * * * * *")
    public void sendUserCounting(){
        UserCountingWebSocketService.sendUserCount();
    }
}
