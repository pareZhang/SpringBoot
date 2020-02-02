package com.zjm.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: pareZhang
 * @Date: 2020/1/13 15:38
 **/
@Configuration
public class RabbitDirectConfig {
    public final static String DIRECTNAME="pareZhang-direct";

    /**
     * 提供一个消息队列
     * @return
     */
    @Bean
    Queue queue(){
        return new Queue("hello-queue");
    }

    /**
     * 创建一个DirectExchange 对象
     * 三个参数分别是名字、重启是否依然有效，以及长期未使用是否删除
     * @return
     */
    @Bean
    DirectExchange directExchange(){
        return new DirectExchange(DIRECTNAME,true,false);
    }

    /**
     * 创建一个Binding对象，将Exchange和Queue绑定在一起
     * @return
     */
    @Bean
    Binding binding(){
        return BindingBuilder.bind(queue())
                .to(directExchange()).with("direct");
    }
}
