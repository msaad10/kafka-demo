package com.app.kafka.Producers;

import com.app.kafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonProducer {
    public static final Logger LOGGER = LoggerFactory.getLogger(JsonProducer.class);
    private KafkaTemplate<String, User> kafkaTemplate;

    public JsonProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User user, String topic) {
        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();
        LOGGER.info(String.format("Producing message -> %s on Topic -> %s", user, topic));
        kafkaTemplate.send(message);
    }
}
