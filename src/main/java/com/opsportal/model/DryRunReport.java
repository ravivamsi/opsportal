package com.opsportal.model;

import java.time.LocalDateTime;
import java.util.List;

public class DryRunReport {
    private String applicationName;
    private String version;
    private String infrastructureDetails;
    private LocalDateTime reportDate;
    private ArtifactStatus artifactStatus;
    private HealthStatus healthStatus;
    private ConfigStatus configStatus;
    private CertSaStatus certSaStatus;
    private String overallStatus;
    private List<String> recommendations;

    public DryRunReport() {
        this.reportDate = LocalDateTime.now();
    }

    // Getters and Setters
    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getInfrastructureDetails() {
        return infrastructureDetails;
    }

    public void setInfrastructureDetails(String infrastructureDetails) {
        this.infrastructureDetails = infrastructureDetails;
    }

    public LocalDateTime getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDateTime reportDate) {
        this.reportDate = reportDate;
    }

    public ArtifactStatus getArtifactStatus() {
        return artifactStatus;
    }

    public void setArtifactStatus(ArtifactStatus artifactStatus) {
        this.artifactStatus = artifactStatus;
    }

    public HealthStatus getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(HealthStatus healthStatus) {
        this.healthStatus = healthStatus;
    }

    public ConfigStatus getConfigStatus() {
        return configStatus;
    }

    public void setConfigStatus(ConfigStatus configStatus) {
        this.configStatus = configStatus;
    }

    public CertSaStatus getCertSaStatus() {
        return certSaStatus;
    }

    public void setCertSaStatus(CertSaStatus certSaStatus) {
        this.certSaStatus = certSaStatus;
    }

    public String getOverallStatus() {
        return overallStatus;
    }

    public void setOverallStatus(String overallStatus) {
        this.overallStatus = overallStatus;
    }

    public List<String> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<String> recommendations) {
        this.recommendations = recommendations;
    }

    // Inner classes for different status types
    public static class ArtifactStatus {
        private String status;
        private String details;
        private List<String> issues;

        public ArtifactStatus() {}

        public ArtifactStatus(String status, String details) {
            this.status = status;
            this.details = details;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

        public List<String> getIssues() {
            return issues;
        }

        public void setIssues(List<String> issues) {
            this.issues = issues;
        }
    }

    public static class HealthStatus {
        private String status;
        private String details;
        private List<String> healthChecks;

        public HealthStatus() {}

        public HealthStatus(String status, String details) {
            this.status = status;
            this.details = details;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

        public List<String> getHealthChecks() {
            return healthChecks;
        }

        public void setHealthChecks(List<String> healthChecks) {
            this.healthChecks = healthChecks;
        }
    }

    public static class ConfigStatus {
        private String status;
        private String details;
        private List<String> configErrors;

        public ConfigStatus() {}

        public ConfigStatus(String status, String details) {
            this.status = status;
            this.details = details;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

        public List<String> getConfigErrors() {
            return configErrors;
        }

        public void setConfigErrors(List<String> configErrors) {
            this.configErrors = configErrors;
        }
    }

    public static class CertSaStatus {
        private String status;
        private String details;
        private List<String> certIssues;
        private List<String> saIssues;

        public CertSaStatus() {}

        public CertSaStatus(String status, String details) {
            this.status = status;
            this.details = details;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

        public List<String> getCertIssues() {
            return certIssues;
        }

        public void setCertIssues(List<String> certIssues) {
            this.certIssues = certIssues;
        }

        public List<String> getSaIssues() {
            return saIssues;
        }

        public void setSaIssues(List<String> saIssues) {
            this.saIssues = saIssues;
        }
    }
} 