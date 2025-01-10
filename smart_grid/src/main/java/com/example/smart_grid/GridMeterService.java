package com.example.smart_grid;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Service
public class GridMeterService {
    private BlockingQueue<String> messages = new LinkedBlockingQueue<>();

    @KafkaListener(topics = "smartgrid", groupId = "groupId")
    public void listener(String data){
        messages.add(data);
    }

    public BlockingQueue<String>getMeterReading(){
        return messages;
    }

}
