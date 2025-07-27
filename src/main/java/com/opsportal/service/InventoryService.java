package com.opsportal.service;

import com.opsportal.model.InventoryItem;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService {

    public List<InventoryItem> loadInventoryData() {
        List<InventoryItem> inventoryItems = new ArrayList<>();
        
        try {
            ClassPathResource resource = new ClassPathResource("inventory.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            
            String line;
            boolean isFirstLine = true;
            
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip header row
                }
                
                String[] parts = line.split(",");
                if (parts.length >= 12) {
                    InventoryItem item = new InventoryItem();
                    item.setServer(parts[0]);
                    item.setApplication(parts[1]);
                    item.setPool(parts[2]);
                    item.setAppid(parts[3]);
                    item.setType(parts[4]);
                    item.setDc(parts[5]);
                    item.setC(parts[6]);
                    item.setPort(parts[7]);
                    item.setPod(parts[8]);
                    item.setNode(parts[9]);
                    item.setDomain(parts[10]);
                    item.setStatus(parts[11]);
                    
                    inventoryItems.add(item);
                }
            }
            
            reader.close();
        } catch (IOException e) {
            // Log error and return empty list
            System.err.println("Error reading inventory CSV: " + e.getMessage());
        }
        
        return inventoryItems;
    }
} 