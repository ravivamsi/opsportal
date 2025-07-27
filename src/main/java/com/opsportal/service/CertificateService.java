package com.opsportal.service;

import com.opsportal.model.CertificateItem;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CertificateService {

    public List<CertificateItem> loadCertificateData() {
        List<CertificateItem> certificateItems = new ArrayList<>();
        
        try {
            ClassPathResource resource = new ClassPathResource("cert.csv");
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
                    CertificateItem item = new CertificateItem();
                    item.setAppname(parts[0]);
                    item.setCertname(parts[1]);
                    item.setCertexpirydate(parts[2]);
                    item.setLastrotation(parts[3]);
                    
                    certificateItems.add(item);
                }
            }
            
            reader.close();
        } catch (IOException e) {
            // Log error and return empty list
            System.err.println("Error reading certificate CSV: " + e.getMessage());
        }
        
        return certificateItems;
    }
} 