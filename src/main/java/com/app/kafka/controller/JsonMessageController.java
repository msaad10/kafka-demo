package com.app.kafka.controller;

import com.app.kafka.Producers.JsonProducer;
import com.app.kafka.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/json-message")
public class JsonMessageController {

    private JsonProducer jsonProducer;

    public JsonMessageController(JsonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        jsonProducer.sendMessage(user, "json_test");
        return ResponseEntity.ok("JSON Message Sent");
    }
}
