package com.zjm;

import com.zjm.bean.Message;
import com.zjm.component.JmsComponent;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class ActivemqApplicationTests {
    @Autowired
    JmsComponent jmsComponent;
    @Test
    void contextLoads() {
        Message msg=new Message();
        msg.setContent("hello jms!");
        msg.setDate(new Date());
        jmsComponent.send(msg);
    }

}
