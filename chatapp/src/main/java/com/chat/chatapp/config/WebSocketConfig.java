package com.chat.chatapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
//web socket message broker configurer : web socket protocol, it provides a way of enabling a continuous 2 way communication connection between
//client and server . STOMP is used for the organization,route messages within the connection. chatrooms etc


// Message broker decides where each message should go to , like which chatroom etc
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat").setAllowedOrigins("http://localhost:8080")
                .withSockJS(); //this is used as a fallback if client servers do not support web sockets
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic"); //whoever is subscribed to /topic will get a broadcast
        registry.setApplicationDestinationPrefixes("/app"); // if server gets any msg with /app prefix process it

    }
}
