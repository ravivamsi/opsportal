package com.opsportal.controller;

import com.opsportal.model.KafkaItem;
import com.opsportal.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    @Autowired
    private KafkaService kafkaService;

    @GetMapping("/data")
    public List<KafkaItem> getKafkaData() {
        return kafkaService.loadKafkaData();
    }
} 