package com.example.kafka.consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics="testTopic", groupId="testGroup")
    public void consume(String message) {
        System.out.println(
                String.format("message received: %s", message)
        );
    }
}
