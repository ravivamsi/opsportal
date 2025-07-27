package com.opsportal.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "health")
public class HealthConfig {
    
    private List<HealthEndpoint> endpoints;

    public List<HealthEndpoint> getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(List<HealthEndpoint> endpoints) {
        this.endpoints = endpoints;
    }

    public static class HealthEndpoint {
        private String name;
        private String url;
        private int timeout = 5000;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getTimeout() {
            return timeout;
        }

        public void setTimeout(int timeout) {
            this.timeout = timeout;
        }
    }
} 