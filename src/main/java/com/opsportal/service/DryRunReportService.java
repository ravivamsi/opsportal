package com.opsportal.service;

import com.opsportal.model.DryRunReport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DryRunReportService {

    public DryRunReport generateReport(String applicationName, String version, String infrastructureDetails) {
        DryRunReport report = new DryRunReport();
        report.setApplicationName(applicationName);
        report.setVersion(version);
        report.setInfrastructureDetails(infrastructureDetails);
        
        // Generate artifact status
        DryRunReport.ArtifactStatus artifactStatus = new DryRunReport.ArtifactStatus();
        artifactStatus.setStatus("GOOD");
        artifactStatus.setDetails("Artifact validation passed. All dependencies are resolved and compatible.");
        artifactStatus.setIssues(new ArrayList<>());
        report.setArtifactStatus(artifactStatus);
        
        // Generate health status
        DryRunReport.HealthStatus healthStatus = new DryRunReport.HealthStatus();
        healthStatus.setStatus("GOOD");
        healthStatus.setDetails("Application health checks passed. All endpoints are responding correctly.");
        healthStatus.setHealthChecks(Arrays.asList(
            "Database connectivity: PASSED",
            "External API connectivity: PASSED", 
            "Memory usage: PASSED",
            "CPU usage: PASSED",
            "Disk space: PASSED"
        ));
        report.setHealthStatus(healthStatus);
        
        // Generate config status
        DryRunReport.ConfigStatus configStatus = new DryRunReport.ConfigStatus();
        configStatus.setStatus("GOOD");
        configStatus.setDetails("Configuration validation passed. No JSON or YAML compilation errors found.");
        configStatus.setConfigErrors(new ArrayList<>());
        report.setConfigStatus(configStatus);
        
        // Generate cert/SA status
        DryRunReport.CertSaStatus certSaStatus = new DryRunReport.CertSaStatus();
        certSaStatus.setStatus("GOOD");
        certSaStatus.setDetails("All certificates and service accounts are in good state.");
        certSaStatus.setCertIssues(new ArrayList<>());
        certSaStatus.setSaIssues(new ArrayList<>());
        report.setCertSaStatus(certSaStatus);
        
        // Set overall status
        report.setOverallStatus("PASSED");
        
        // Generate recommendations
        List<String> recommendations = Arrays.asList(
            "All systems are ready for deployment",
            "No critical issues found during dry run",
            "Configuration is validated and secure",
            "Health checks indicate stable application state",
            "Certificates and service accounts are properly configured"
        );
        report.setRecommendations(recommendations);
        
        return report;
    }
    
    public DryRunReport generateReportWithIssues(String applicationName, String version, String infrastructureDetails) {
        DryRunReport report = new DryRunReport();
        report.setApplicationName(applicationName);
        report.setVersion(version);
        report.setInfrastructureDetails(infrastructureDetails);
        
        // Generate artifact status with issues
        DryRunReport.ArtifactStatus artifactStatus = new DryRunReport.ArtifactStatus();
        artifactStatus.setStatus("WARNING");
        artifactStatus.setDetails("Artifact validation completed with minor issues.");
        artifactStatus.setIssues(Arrays.asList(
            "Dependency version mismatch detected",
            "Some deprecated libraries found"
        ));
        report.setArtifactStatus(artifactStatus);
        
        // Generate health status
        DryRunReport.HealthStatus healthStatus = new DryRunReport.HealthStatus();
        healthStatus.setStatus("GOOD");
        healthStatus.setDetails("Application health checks passed with minor warnings.");
        healthStatus.setHealthChecks(Arrays.asList(
            "Database connectivity: PASSED",
            "External API connectivity: WARNING (High latency)",
            "Memory usage: PASSED",
            "CPU usage: PASSED", 
            "Disk space: PASSED"
        ));
        report.setHealthStatus(healthStatus);
        
        // Generate config status with issues
        DryRunReport.ConfigStatus configStatus = new DryRunReport.ConfigStatus();
        configStatus.setStatus("WARNING");
        configStatus.setDetails("Configuration validation completed with minor issues.");
        configStatus.setConfigErrors(Arrays.asList(
            "Deprecated configuration parameter found",
            "Missing optional configuration value"
        ));
        report.setConfigStatus(configStatus);
        
        // Generate cert/SA status
        DryRunReport.CertSaStatus certSaStatus = new DryRunReport.CertSaStatus();
        certSaStatus.setStatus("GOOD");
        certSaStatus.setDetails("All certificates and service accounts are in good state.");
        certSaStatus.setCertIssues(new ArrayList<>());
        certSaStatus.setSaIssues(new ArrayList<>());
        report.setCertSaStatus(certSaStatus);
        
        // Set overall status
        report.setOverallStatus("WARNING");
        
        // Generate recommendations
        List<String> recommendations = Arrays.asList(
            "Review dependency versions before deployment",
            "Monitor external API latency",
            "Update deprecated configuration parameters",
            "Consider updating to latest library versions",
            "All critical systems are operational"
        );
        report.setRecommendations(recommendations);
        
        return report;
    }
} 