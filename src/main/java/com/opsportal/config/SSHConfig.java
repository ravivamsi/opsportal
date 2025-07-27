package com.opsportal.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "ssh")
public class SSHConfig {
    
    private int defaultTimeout = 30000;
    private List<SSHServer> servers;

    public int getDefaultTimeout() {
        return defaultTimeout;
    }

    public void setDefaultTimeout(int defaultTimeout) {
        this.defaultTimeout = defaultTimeout;
    }

    public List<SSHServer> getServers() {
        return servers;
    }

    public void setServers(List<SSHServer> servers) {
        this.servers = servers;
    }

    public static class SSHServer {
        private String name;
        private String host;
        private int port = 22;
        private String username;
        private String keyPath;

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

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getKeyPath() {
            return keyPath;
        }

        public void setKeyPath(String keyPath) {
            this.keyPath = keyPath;
        }
    }
} 