package com.example.kafka.producers;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private KafkaTemplate<String, String> template;

    public KafkaProducer(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    public void sendMessage(String message) {
        System.out.println(
                String.format("сообщение:%s отправлено", message)
        );
        template.send("testTopic", message);
    }
}
