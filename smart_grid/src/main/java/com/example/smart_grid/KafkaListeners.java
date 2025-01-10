package com.example.smart_grid;

import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "smartgrid", groupId = "groupId")
    void listener(String data){
        System.out.println(data + " Received");
    }
}
