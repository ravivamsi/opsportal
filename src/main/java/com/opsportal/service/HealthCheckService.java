package com.opsportal.service;

import com.opsportal.model.HealthCheckResult;
import com.opsportal.config.HealthConfig;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
public class HealthCheckService {

    @Autowired
    private HealthConfig healthConfig;

    public List<HealthCheckResult> performHealthChecks() {
        List<HealthCheckResult> results = new ArrayList<>();
        
        for (HealthConfig.HealthEndpoint endpoint : healthConfig.getEndpoints()) {
            CompletableFuture<HealthCheckResult> future = CompletableFuture.supplyAsync(() -> 
                checkHealth(endpoint));
            
            try {
                HealthCheckResult result = future.get(endpoint.getTimeout(), TimeUnit.MILLISECONDS);
                results.add(result);
            } catch (Exception e) {
                HealthCheckResult errorResult = new HealthCheckResult(endpoint.getName(), "DOWN", endpoint.getUrl());
                errorResult.setErrorMessage("Timeout or connection error: " + e.getMessage());
                results.add(errorResult);
            }
        }
        
        return results;
    }

    private HealthCheckResult checkHealth(HealthConfig.HealthEndpoint endpoint) {
        long startTime = System.currentTimeMillis();
        
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.getForEntity(endpoint.getUrl(), String.class);
            
            long responseTime = System.currentTimeMillis() - startTime;
            
            HealthCheckResult result = new HealthCheckResult(endpoint.getName(), "UP", endpoint.getUrl());
            result.setResponseTime(responseTime);
            
            if (response.getStatusCode().value() != 200) {
                result.setStatus("DOWN");
                result.setErrorMessage("HTTP Status: " + response.getStatusCode().value());
            }
            
            return result;
            
        } catch (RestClientException e) {
            long responseTime = System.currentTimeMillis() - startTime;
            HealthCheckResult result = new HealthCheckResult(endpoint.getName(), "DOWN", endpoint.getUrl());
            result.setResponseTime(responseTime);
            result.setErrorMessage("Connection error: " + e.getMessage());
            return result;
        }
    }


} 