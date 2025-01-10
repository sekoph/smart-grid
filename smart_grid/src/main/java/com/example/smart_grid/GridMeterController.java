package com.example.smart_grid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.ArrayList;



@RestController
@RequestMapping("api/v1/grid")
public class GridMeterController {

    @Autowired
    private GridMeterService gridMeterService;

    private KafkaTemplate<String, String> kafkaTemplate;
    // private KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> factory;


    public GridMeterController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping()
    public void publish(@RequestBody GridMeterReadRequest request){
        kafkaTemplate.send("smartgrid", request.message());
    }

    @GetMapping()
    public List<String> getMeterReading() {
        List<String> messages = new ArrayList<>();
        gridMeterService.getMeterReading().drainTo(messages);
        return messages;
    }
    
}
