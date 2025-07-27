package com.opsportal.service;

import com.opsportal.model.ServiceAccountItem;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceAccountService {

    public List<ServiceAccountItem> loadServiceAccountData() {
        List<ServiceAccountItem> serviceAccountItems = new ArrayList<>();
        
        try {
            ClassPathResource resource = new ClassPathResource("sa.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            
            String line;
            boolean isFirstLine = true;
            
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip header row
                }
                
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    ServiceAccountItem item = new ServiceAccountItem();
                    item.setAppname(parts[0]);
                    item.setSaname(parts[1]);
                    item.setSaexpirydate(parts[2]);
                    item.setLastrotation(parts[3]);
                    
                    serviceAccountItems.add(item);
                }
            }
            
            reader.close();
        } catch (IOException e) {
            // Log error and return empty list
            System.err.println("Error reading service account CSV: " + e.getMessage());
        }
        
        return serviceAccountItems;
    }
} 