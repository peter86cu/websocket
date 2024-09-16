package com.pet.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notifications")
public class WebSocketNotificationController {

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public WebSocketNotificationController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @PostMapping("/send")
    public void sendNotification(@RequestBody NotificationMessage message) {
        // Forward the message to the WebSocket topic
        messagingTemplate.convertAndSend(message.getType(), message.getContent());
    }
}
