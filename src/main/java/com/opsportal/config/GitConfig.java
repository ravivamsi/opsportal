package com.opsportal.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "git")
public class GitConfig {
    
    private List<GitRepository> repositories;

    public List<GitRepository> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<GitRepository> repositories) {
        this.repositories = repositories;
    }

    public static class GitRepository {
        private String name;
        private String url;
        private String localPath;
        private List<String> branches;

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

        public String getLocalPath() {
            return localPath;
        }

        public void setLocalPath(String localPath) {
            this.localPath = localPath;
        }

        public List<String> getBranches() {
            return branches;
        }

        public void setBranches(List<String> branches) {
            this.branches = branches;
        }
    }
} 