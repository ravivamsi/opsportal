package com.opsportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("title", "Operations Portal Dashboard");
        return "dashboard";
    }

    @GetMapping("/health")
    public String healthPage(Model model) {
        model.addAttribute("title", "Health Checks");
        return "health";
    }

    @GetMapping("/infrastructure")
    public String infrastructurePage(Model model) {
        model.addAttribute("title", "Infrastructure Report");
        return "infrastructure";
    }

    @GetMapping("/linux-commands")
    public String linuxCommandsPage(Model model) {
        model.addAttribute("title", "Linux Command Execution");
        return "linux-commands";
    }

    @GetMapping("/windows-commands")
    public String windowsCommandsPage(Model model) {
        model.addAttribute("title", "Windows Command Execution");
        return "windows-commands";
    }

    @GetMapping("/config-diff")
    public String configDiffPage(Model model) {
        model.addAttribute("title", "Configuration File Differences");
        return "config-diff";
    }
} 