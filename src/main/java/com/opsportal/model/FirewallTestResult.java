package com.opsportal.model;

import java.time.LocalDateTime;

public class FirewallTestResult {
    private String serverName;
    private String clusterName;
    private String dns;
    private int port;
    private String status;
    private String responseTime;
    private String errorMessage;
    private LocalDateTime timestamp;

    public FirewallTestResult() {
        this.timestamp = LocalDateTime.now();
    }

    public FirewallTestResult(String serverName, String clusterName, String dns, int port, String status, String responseTime) {
        this.serverName = serverName;
        this.clusterName = clusterName;
        this.dns = dns;
        this.port = port;
        this.status = status;
        this.responseTime = responseTime;
        this.timestamp = LocalDateTime.now();
    }

    // Getters and Setters
    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public String getDns() {
        return dns;
    }

    public void setDns(String dns) {
        this.dns = dns;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
} 