package com.zjm.component;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: pareZhang
 * @Date: 2020/1/13 15:52
 * 配置一个消费者
 **/
@Component
public class DirectReceiver {
    /**
     * 通过@RabbitListener指定一个方法是一个消息消费方法，方法参数就是所接收到的消息
     * @param msg
     */
    @RabbitListener(queues="hello-queue")
    public void handler1(String msg){
        System.out.println("DirectReceiver:"+msg);
    }
}
