package com.zjm.component;

import com.zjm.bean.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
import javax.jms.Queue;

/**
 * 创建一个JMS组件来完成消息的发送和接收
 */
@Component
public class JmsComponent {
    @Autowired
    JmsMessagingTemplate messagingTemplate;
    @Autowired
    Queue queue;
    public void send(Message msg){
        messagingTemplate.convertAndSend(this.queue,msg);
    }
    @JmsListener(destination = "amq")
    public void receive(Message msg){
        System.out.println("receive:"+msg);
    }
}
