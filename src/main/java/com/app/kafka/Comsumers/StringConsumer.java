package com.app.kafka.Comsumers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StringConsumer {
    public static final Logger LOGGER = LoggerFactory.getLogger(StringConsumer.class);

    @KafkaListener(topics="test", groupId = "myGroup")
    public void consume(String message) {
        LOGGER.info(String.format("Consuming message -> %s", message));
    }
}
