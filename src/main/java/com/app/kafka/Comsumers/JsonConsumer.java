package com.app.kafka.Comsumers;

import com.app.kafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonConsumer {
    public static final Logger LOGGER = LoggerFactory.getLogger(JsonConsumer.class);

    @KafkaListener(topics="json_test", groupId = "myGroup")
    public void consume(User user) {
        LOGGER.info(String.format("Consuming message -> %s", user));
    }
}
