package com.opsportal.service;

import com.opsportal.model.KafkaItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaService {

    public List<KafkaItem> loadKafkaData() {
        List<KafkaItem> kafkaItems = new ArrayList<>();
        
        // App1 - 9 records
        kafkaItems.add(new KafkaItem("app1", "user-events", "cert1", "READ, WRITE"));
        kafkaItems.add(new KafkaItem("app1", "order-events", "cert2", "READ"));
        kafkaItems.add(new KafkaItem("app1", "payment-events", "cert3", "READ, WRITE"));
        kafkaItems.add(new KafkaItem("app1", "inventory-updates", "sa1", "READ"));
        kafkaItems.add(new KafkaItem("app1", "notification-events", "sa2", "WRITE"));
        kafkaItems.add(new KafkaItem("app1", "audit-logs", "sa3", "READ"));
        kafkaItems.add(new KafkaItem("app1", "metrics-data", "cert4", "READ, WRITE"));
        kafkaItems.add(new KafkaItem("app1", "error-logs", "cert5", "WRITE"));
        kafkaItems.add(new KafkaItem("app1", "system-events", "sa4", "READ, WRITE"));
        
        // App2 - 9 records
        kafkaItems.add(new KafkaItem("app2", "user-events", "cert6", "READ"));
        kafkaItems.add(new KafkaItem("app2", "order-events", "cert7", "READ, WRITE"));
        kafkaItems.add(new KafkaItem("app2", "payment-events", "cert8", "READ"));
        kafkaItems.add(new KafkaItem("app2", "inventory-updates", "sa5", "READ, WRITE"));
        kafkaItems.add(new KafkaItem("app2", "notification-events", "sa6", "READ"));
        kafkaItems.add(new KafkaItem("app2", "audit-logs", "sa7", "READ, WRITE"));
        kafkaItems.add(new KafkaItem("app2", "metrics-data", "cert9", "READ"));
        kafkaItems.add(new KafkaItem("app2", "error-logs", "cert10", "READ, WRITE"));
        kafkaItems.add(new KafkaItem("app2", "system-events", "sa8", "READ"));
        
        // App3 - 9 records
        kafkaItems.add(new KafkaItem("app3", "user-events", "cert11", "READ, WRITE"));
        kafkaItems.add(new KafkaItem("app3", "order-events", "cert12", "READ"));
        kafkaItems.add(new KafkaItem("app3", "payment-events", "cert13", "READ, WRITE"));
        kafkaItems.add(new KafkaItem("app3", "inventory-updates", "sa9", "READ, WRITE"));
        kafkaItems.add(new KafkaItem("app3", "notification-events", "sa10", "READ"));
        kafkaItems.add(new KafkaItem("app3", "audit-logs", "sa11", "READ, WRITE"));
        kafkaItems.add(new KafkaItem("app3", "metrics-data", "cert14", "READ"));
        kafkaItems.add(new KafkaItem("app3", "error-logs", "cert15", "READ, WRITE"));
        kafkaItems.add(new KafkaItem("app3", "system-events", "sa12", "READ"));
        
        return kafkaItems;
    }
} 