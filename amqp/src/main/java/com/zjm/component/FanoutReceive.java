package com.zjm.component;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: pareZhang
 * @Date: 2020/1/13 17:15
 **/
@Component
public class FanoutReceive {
    @RabbitListener(queues = "queue-one")
    public void handler1(String message){
        System.out.println("FanoutReceiver:handler1:"+message);
    }
    @RabbitListener(queues = "queue-two")
    public void handler2(String message){
        System.out.println("FanoutReceiver:handler2:"+message);
    }
}
