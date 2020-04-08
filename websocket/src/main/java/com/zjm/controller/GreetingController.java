package com.zjm.controller;

import com.zjm.bean.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @Author: pareZhang
 * @Date: 2020/2/2 16:42
 **/
@Controller
public class GreetingController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    /**
     * 根据配置类的配置，@MessageMapping("/hello")注解的方法将用来接收/app/hello路径发送来的消息，在注解方法中对消息进行处理后
     * 再将消息转发到@SendTo定义的路径上，而@SendTo是一个前缀为/topic的路径，因此该消息将被交给消息代理broker，再由broker进行广播
     */
    public Message greeting(Message message)throws Exception{
        return message;
    }
}
