package com.franc1s.chat02.controller;

import com.franc1s.chat02.model.Chat;
import com.franc1s.chat02.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class GreetingController {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message greeting(Message message) {
        return message;
    }

    @MessageMapping("/online_chat")
    public void chat(Principal principal, Chat chat) {
        String from = principal.getName();
        chat.setFrom(from);
        simpMessagingTemplate.convertAndSendToUser(chat.getTo(),"/queue/chat",chat);
    }
}
