package com.zjm.component;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: pareZhang
 * @Date: 2020/1/14 14:26
 **/
@Component
public class TopicReceive {
    @RabbitListener(queues = "phone")
    public void handler1(String message){
        System.out.println("PhoneReceiver:"+message);
    }
    @RabbitListener(queues = "xiaomi")
    public void handler2(String message){
        System.out.println("XiaoMiReceiver:"+message);
    }
    @RabbitListener(queues = "huawei")
    public void handler3(String message){
        System.out.println("HuaWeiReceiver:"+message);
    }
}
