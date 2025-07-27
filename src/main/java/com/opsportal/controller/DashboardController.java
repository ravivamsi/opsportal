package com.opsportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("title", "Dashboard");
        return "dashboard";
    }

    // Dashboard Section
    @GetMapping("/market-open")
    public String marketOpen(Model model) {
        model.addAttribute("title", "Market Open");
        return "market-open";
    }

    @GetMapping("/system-health")
    public String systemHealth(Model model) {
        model.addAttribute("title", "System Health");
        return "system-health";
    }

    @GetMapping("/inventory")
    public String inventory(Model model) {
        model.addAttribute("title", "Inventory");
        return "inventory";
    }

    // Dry Run Section
    @GetMapping("/dry-run/report")
    public String dryRunReport(Model model) {
        model.addAttribute("title", "Dry Run Report");
        return "dry-run-report";
    }

    @GetMapping("/dry-run/linux")
    public String dryRunLinux(Model model) {
        model.addAttribute("title", "Dry Run - Linux");
        return "dry-run-linux";
    }

    @GetMapping("/dry-run/windows")
    public String dryRunWindows(Model model) {
        model.addAttribute("title", "Dry Run - Windows");
        return "dry-run-windows";
    }

    // Break Glass Section
    @GetMapping("/break-glass/traffic-controller")
    public String breakGlassTrafficController(Model model) {
        model.addAttribute("title", "Break Glass - Traffic Controller");
        return "break-glass-traffic-controller";
    }

    @GetMapping("/break-glass/dr-ops")
    public String breakGlassDrOps(Model model) {
        model.addAttribute("title", "Break Glass - DR Ops");
        return "break-glass-dr-ops";
    }

    @GetMapping("/break-glass/emergency-ops")
    public String breakGlassEmergencyOps(Model model) {
        model.addAttribute("title", "Break Glass - Emergency Ops");
        return "break-glass-emergency-ops";
    }

    // DoD Section
    @GetMapping("/dod/config-review")
    public String dodConfigReview(Model model) {
        model.addAttribute("title", "DoD - Config Review");
        return "dod-config-review";
    }

    @GetMapping("/dod/kafka")
    public String dodKafka(Model model) {
        model.addAttribute("title", "DoD - Kafka");
        return "dod-kafka";
    }

    @GetMapping("/dod/certificate")
    public String dodCertificate(Model model) {
        model.addAttribute("title", "DoD - Certificate");
        return "dod-certificate";
    }

    @GetMapping("/dod/service-accounts")
    public String dodServiceAccounts(Model model) {
        model.addAttribute("title", "DoD - Service Accounts");
        return "dod-service-accounts";
    }

    @GetMapping("/dod/firewall")
    public String dodFirewall(Model model) {
        model.addAttribute("title", "DoD - Firewall");
        return "dod-firewall";
    }
} 