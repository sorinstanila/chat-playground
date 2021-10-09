package de.audibene.chat.controller;

import java.util.Map;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import de.audibene.chat.model.ChatMessage;

@Controller
public class ChatController {

    @MessageMapping("/chat/sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/chat/addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, 
                               SimpMessageHeaderAccessor headerAccessor) {

        // Add username in web socket session
        final Map<String, Object> attributes = headerAccessor.getSessionAttributes();
        if ( attributes != null ) {
            attributes.put("username", chatMessage.getSender());
        }
        return chatMessage;
    }

    @SubscribeMapping("/topic/system")
    public ChatMessage discoverChannels(SimpMessageHeaderAccessor headerAccessor){
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setType(ChatMessage.MessageType.CHAT);
        chatMessage.setContent("discover me");
        final Map<String, Object> attributes = headerAccessor.getSessionAttributes();
        
        if ( attributes.get("username") != null ) {
            final String username = attributes.get("username").toString();
            chatMessage.setContent("discover me "+ username);
        }
      
        chatMessage.setSender("system");

        return chatMessage;
    }

    @SubscribeMapping("/topic/{channel-id}")
    public ChatMessage retrieveHistory(
        @DestinationVariable("channel-id") final String channelId
    ){
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setType(ChatMessage.MessageType.CHAT);
        chatMessage.setContent("discover for: " + channelId);
        chatMessage.setSender("system");

        return chatMessage;
    }

}
