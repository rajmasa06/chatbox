package com.example.chatbot;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class WebhookController {

    @PostMapping("/webhook")
    public Map<String, String> receiveMessage(@RequestBody Map<String, String> payload) {
        String message = payload.getOrDefault("message", "").toLowerCase();

        String reply;
        if (message.equals("hi")) {
            reply = "Hello";
        } else if (message.equals("bye")) {
            reply = "Goodbye";
        } else {
            reply = "I didn't understand that.";
        }

        System.out.println("Incoming message: " + message);

        return Map.of("reply", reply);
    }
}
