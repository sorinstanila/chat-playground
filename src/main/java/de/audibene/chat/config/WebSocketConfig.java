package de.audibene.chat.config;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableRabbit
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Autowired
    private  BrokerConfig config;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app", "/user");
        registry.setPreservePublishOrder(true);
        registry.setPathMatcher(new AntPathMatcher("/"));
    
        // Use this for enabling a Full featured broker like RabbitMQ
        registry.enableStompBrokerRelay("/topic")
                .setUserDestinationBroadcast("/topic/unresolved-users")
                .setUserRegistryBroadcast("/topic/regitered-users")
                // .setVirtualHost("chat-playground") // playground for RebbitMQ
                .setRelayHost(config.host)
                .setRelayPort(config.port)
                .setClientLogin(config.username)
                .setClientPasscode(config.password)
                .setSystemLogin(config.username)
                .setSystemPasscode(config.password);
    }
}
