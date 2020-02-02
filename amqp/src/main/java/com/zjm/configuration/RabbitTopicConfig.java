package com.zjm.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: pareZhang
 * @Date: 2020/1/14 14:12
 * 在TopicExchange中，Queue通过routingKey绑定到TopicExchange上，当消息到达TopicExchange后，TopicExchange根据消息的
 * routingKey将消息路由到一个或多个Queue上，
 *
 **/
@Configuration
public class RabbitTopicConfig {
    public final static String TOPICNAME="pareZhang-topic";
    @Bean
    TopicExchange topicExchange(){
        return new TopicExchange(TOPICNAME,true,false);
    }
    @Bean
    Queue huawei(){
        return new Queue("huawei");
    }
    @Bean
    Queue xiaomi(){
        return new Queue("xiaomi");
    }
    @Bean
    Queue phone(){
        return new Queue("phone");
    }
    @Bean
    Binding huaweiBinding(){
        return BindingBuilder.bind(huawei()).to(topicExchange()).with("huawei.#");
    }
    @Bean
    Binding xiaomiBinding(){
        return BindingBuilder.bind(xiaomi()).to(topicExchange()).with("xioami.#");
    }
    @Bean
    Binding phoneBinding(){
        return BindingBuilder.bind(phone()).to(topicExchange()).with("#.phone.#");
    }
}
