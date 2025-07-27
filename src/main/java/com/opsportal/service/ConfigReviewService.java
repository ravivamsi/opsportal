package com.opsportal.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opsportal.model.ConfigDiffResult;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class ConfigReviewService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public ConfigDiffResult compareConfigs() {
        try {
            // Load both config files
            ClassPathResource config1Resource = new ClassPathResource("config1.json");
            ClassPathResource config2Resource = new ClassPathResource("config2.json");
            
            JsonNode config1 = objectMapper.readTree(config1Resource.getInputStream());
            JsonNode config2 = objectMapper.readTree(config2Resource.getInputStream());
            
            List<String> differences = new ArrayList<>();
            
            // Compare the two JSON objects
            compareJsonNodes("", config1, config2, differences);
            
            return new ConfigDiffResult(
                "config1.json",
                "config2.json", 
                "main",
                "feature",
                String.join("\n", differences),
                differences.size()
            );
            
        } catch (IOException e) {
            return new ConfigDiffResult(
                "config1.json",
                "config2.json",
                "main", 
                "feature",
                "Error loading configuration files: " + e.getMessage(),
                0
            );
        }
    }

    private void compareJsonNodes(String path, JsonNode node1, JsonNode node2, List<String> differences) {
        if (node1.isObject() && node2.isObject()) {
            // Compare object fields
            Iterator<Map.Entry<String, JsonNode>> fields1 = node1.fields();
            while (fields1.hasNext()) {
                Map.Entry<String, JsonNode> field1 = fields1.next();
                String fieldName = field1.getKey();
                JsonNode value1 = field1.getValue();
                JsonNode value2 = node2.get(fieldName);
                
                String currentPath = path.isEmpty() ? fieldName : path + "." + fieldName;
                
                if (value2 == null) {
                    differences.add("- " + currentPath + ": " + value1.toString());
                } else {
                    compareJsonNodes(currentPath, value1, value2, differences);
                }
            }
            
            // Check for fields in node2 that don't exist in node1
            Iterator<Map.Entry<String, JsonNode>> fields2 = node2.fields();
            while (fields2.hasNext()) {
                Map.Entry<String, JsonNode> field2 = fields2.next();
                String fieldName = field2.getKey();
                JsonNode value2 = field2.getValue();
                JsonNode value1 = node1.get(fieldName);
                
                String currentPath = path.isEmpty() ? fieldName : path + "." + fieldName;
                
                if (value1 == null) {
                    differences.add("+ " + currentPath + ": " + value2.toString());
                }
            }
        } else if (node1.isArray() && node2.isArray()) {
            // Compare arrays
            int size1 = node1.size();
            int size2 = node2.size();
            int maxSize = Math.max(size1, size2);
            
            for (int i = 0; i < maxSize; i++) {
                String currentPath = path + "[" + i + "]";
                
                if (i >= size1) {
                    differences.add("+ " + currentPath + ": " + node2.get(i).toString());
                } else if (i >= size2) {
                    differences.add("- " + currentPath + ": " + node1.get(i).toString());
                } else {
                    compareJsonNodes(currentPath, node1.get(i), node2.get(i), differences);
                }
            }
        } else {
            // Compare primitive values
            if (!node1.equals(node2)) {
                differences.add("- " + path + ": " + node1.toString());
                differences.add("+ " + path + ": " + node2.toString());
            }
        }
    }
} 