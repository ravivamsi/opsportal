package com.opsportal.controller;

import com.opsportal.model.HealthCheckResult;
import com.opsportal.service.HealthCheckService;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/health")
public class HealthController {

    @Autowired
    private HealthCheckService healthCheckService;

    @GetMapping("/check-all")
    public ResponseEntity<List<HealthCheckResult>> checkAllHealth() {
        List<HealthCheckResult> results = healthCheckService.performHealthChecks();
        return ResponseEntity.ok(results);
    }

    @GetMapping("/check/{serviceName}")
    public ResponseEntity<HealthCheckResult> checkSpecificHealth(@PathVariable String serviceName, 
                                                              @RequestParam String url) {
        long startTime = System.currentTimeMillis();
        
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            
            long responseTime = System.currentTimeMillis() - startTime;
            
            HealthCheckResult result = new HealthCheckResult(serviceName, "UP", url);
            result.setResponseTime(responseTime);
            
            if (response.getStatusCode().value() != 200) {
                result.setStatus("DOWN");
                result.setErrorMessage("HTTP Status: " + response.getStatusCode().value());
            }
            
            return ResponseEntity.ok(result);
            
        } catch (RestClientException e) {
            long responseTime = System.currentTimeMillis() - startTime;
            HealthCheckResult result = new HealthCheckResult(serviceName, "DOWN", url);
            result.setResponseTime(responseTime);
            result.setErrorMessage("Connection error: " + e.getMessage());
            return ResponseEntity.ok(result);
        }
    }

    @PostMapping("/check-custom")
    public ResponseEntity<HealthCheckResult> checkCustomHealth(@RequestParam String serviceName,
                                                             @RequestParam String url,
                                                             @RequestParam(defaultValue = "5000") int timeout) {
        long startTime = System.currentTimeMillis();
        
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            
            long responseTime = System.currentTimeMillis() - startTime;
            
            HealthCheckResult result = new HealthCheckResult(serviceName, "UP", url);
            result.setResponseTime(responseTime);
            
            if (response.getStatusCode().value() != 200) {
                result.setStatus("DOWN");
                result.setErrorMessage("HTTP Status: " + response.getStatusCode().value());
            }
            
            return ResponseEntity.ok(result);
            
        } catch (RestClientException e) {
            long responseTime = System.currentTimeMillis() - startTime;
            HealthCheckResult result = new HealthCheckResult(serviceName, "DOWN", url);
            result.setResponseTime(responseTime);
            result.setErrorMessage("Connection error: " + e.getMessage());
            return ResponseEntity.ok(result);
        }
    }
} 