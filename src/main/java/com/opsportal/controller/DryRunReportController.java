package com.opsportal.controller;

import com.opsportal.model.DryRunReport;
import com.opsportal.service.DryRunReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dry-run")
public class DryRunReportController {

    @Autowired
    private DryRunReportService dryRunReportService;

    @PostMapping("/generate-report")
    public DryRunReport generateReport(@RequestParam String applicationName, 
                                     @RequestParam String version, 
                                     @RequestParam String infrastructureDetails) {
        return dryRunReportService.generateReport(applicationName, version, infrastructureDetails);
    }
    
    @PostMapping("/generate-report-with-issues")
    public DryRunReport generateReportWithIssues(@RequestParam String applicationName, 
                                               @RequestParam String version, 
                                               @RequestParam String infrastructureDetails) {
        return dryRunReportService.generateReportWithIssues(applicationName, version, infrastructureDetails);
    }
} 