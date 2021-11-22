package com.example.messagingstompwebsocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

//to indicate that it is a Spring configuration class
@Configuration
//enables WebSocket message handling, backed by a message broker
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {

        //to enable a simple memory-based message broker to carry the greeting messages back to the client on destinations prefixed with /topic
        config.enableSimpleBroker("/topic");
        //It also designates the /app prefix for messages that are bound for methods annotated with @MessageMapping (controller단)
        //the endpoint that the GreetingController.greeting() method is mapped to handle
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
    }
}
