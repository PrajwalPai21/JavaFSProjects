// Handles all the incoming messages from the front end and broadcast it to all the clients.

package com.chat.chatapp.controller;

import com.chat.chatapp.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {
    @MessageMapping("/sendMessage") //this method is called when message is sent to process it
    @SendTo("/topic/messages") //send the message to specific subscribbed chatroom
    public ChatMessage sendMessage(ChatMessage message){
        return message;
    }

    @GetMapping("/")
    public String chat() {
        return "chat"; //This is thymeleaf template chat.html
    }
}
