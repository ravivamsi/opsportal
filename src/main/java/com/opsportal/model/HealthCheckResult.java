package com.opsportal.model;

import java.time.LocalDateTime;

public class HealthCheckResult {
    private String serviceName;
    private String status;
    private String url;
    private LocalDateTime timestamp;
    private long responseTime;
    private String errorMessage;

    public HealthCheckResult() {}

    public HealthCheckResult(String serviceName, String status, String url) {
        this.serviceName = serviceName;
        this.status = status;
        this.url = url;
        this.timestamp = LocalDateTime.now();
    }

    // Getters and Setters
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
} 