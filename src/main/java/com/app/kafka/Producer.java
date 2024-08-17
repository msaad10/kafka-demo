package com.app.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    public static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);
    private KafkaTemplate<String, String> kafkaTemplate;

    public Producer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String message) {
        LOGGER.info(String.format("Producing message -> %s on Topic -> %s", message, topic));
        kafkaTemplate.send(topic, message);
    }
}
