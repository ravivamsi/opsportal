package com.opsportal.controller;

import com.opsportal.model.ConfigDiffResult;
import com.opsportal.service.ConfigReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/config-review")
public class ConfigReviewController {

    @Autowired
    private ConfigReviewService configReviewService;

    @GetMapping("/default")
    public ConfigDiffResult getDefaultConfigDiff() {
        return configReviewService.compareConfigs();
    }
} 