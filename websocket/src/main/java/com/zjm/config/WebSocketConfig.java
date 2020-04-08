package com.zjm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @Author: pareZhang
 * @Date: 2020/2/2 15:43
 **/
@Configuration
@EnableWebSocketMessageBroker  //开启websocket消息代理
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //表示设置消息代理的前缀，即如果消息的前缀是/topic，就会把消息转发给消息代理（broker），
        // 再由消息代理将消息广播给当前连接的客户端
        registry.enableSimpleBroker("/topic");
        //表示配置一个或多个前缀，通过这些前缀过滤出需要被注解方法处理的消息
        //例如前缀为/app的destination可以通过@MessageMapping注解的方法处理，而其他destination（如/topic /queue）将被直接交给broker处理
        registry.setApplicationDestinationPrefixes("/app");
    }
    public void registerStompEndpoints(StompEndpointRegistry registry){
        //表示定义一个前缀为/chat的endpoint，并开启sockjs支持，sockjs可以解决浏览器对websocket的兼容性问题，客户端将通过这里配置的URL来建立websocket连接
        registry.addEndpoint("/chat").withSockJS();
    }
}
