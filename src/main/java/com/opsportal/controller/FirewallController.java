package com.opsportal.controller;

import com.opsportal.model.FirewallTestResult;
import com.opsportal.service.FirewallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/firewall")
public class FirewallController {

    @Autowired
    private FirewallService firewallService;

    @PostMapping("/test")
    public List<FirewallTestResult> runFirewallTest(@RequestParam String clusterName, 
                                                   @RequestParam String dns, 
                                                   @RequestParam int port) {
        return firewallService.runFirewallTest(clusterName, dns, port);
    }
} 