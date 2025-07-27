package com.opsportal.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "windows")
public class WindowsConfig {
    
    private List<WindowsServer> servers;

    public List<WindowsServer> getServers() {
        return servers;
    }

    public void setServers(List<WindowsServer> servers) {
        this.servers = servers;
    }

    public static class WindowsServer {
        private String name;
        private String host;
        private String username;
        private String domain;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }
    }
} 