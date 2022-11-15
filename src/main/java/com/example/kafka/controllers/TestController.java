package com.example.kafka.controllers;

import com.example.kafka.producers.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/send")
    public ResponseEntity<String> send(@RequestParam String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message send");
    }

    @PostMapping("/testEndPoint")
    public ResponseEntity<String> testEndPoint(@RequestBody String body) {
        System.out.println(body);
        return ResponseEntity.ok(body);
    }
}
