package com.chatback.listeners;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

import java.util.ArrayList;
import java.util.List;

@Component
public class SessionConnectedEventListener implements ApplicationListener<SessionConnectedEvent> {

    private List<WebSocketSession> sessions = new ArrayList<>();


    public void onApplicationEvent(SessionConnectEvent event) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());

        String  company = sha.getNativeHeader("company").get(0);
        logger.debug("Connect event [sessionId: " + sha.getSessionId() +"; company: "+ company + " ]");
    }

}