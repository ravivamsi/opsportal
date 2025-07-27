package com.opsportal.service;

import com.opsportal.model.FirewallTestResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class FirewallService {

    public List<FirewallTestResult> runFirewallTest(String clusterName, String dns, int port) {
        List<FirewallTestResult> results = new ArrayList<>();
        Random random = new Random();
        
        // Generate dummy servers based on cluster
        List<String> servers = getServersForCluster(clusterName);
        
        for (String server : servers) {
            // Simulate firewall test with random results
            boolean isBlocked = random.nextBoolean();
            String status = isBlocked ? "BLOCKED" : "ALLOWED";
            String responseTime = isBlocked ? "N/A" : (random.nextInt(100) + 10) + "ms";
            String errorMessage = isBlocked ? "Connection timeout - Firewall blocked" : null;
            
            FirewallTestResult result = new FirewallTestResult(
                server, 
                clusterName, 
                dns, 
                port, 
                status, 
                responseTime
            );
            
            if (errorMessage != null) {
                result.setErrorMessage(errorMessage);
            }
            
            results.add(result);
        }
        
        return results;
    }
    
    private List<String> getServersForCluster(String clusterName) {
        List<String> servers = new ArrayList<>();
        
        switch (clusterName) {
            case "cluster1":
                servers.add("server1-cluster1");
                servers.add("server2-cluster1");
                servers.add("server3-cluster1");
                servers.add("server4-cluster1");
                break;
            case "cluster2":
                servers.add("server1-cluster2");
                servers.add("server2-cluster2");
                servers.add("server3-cluster2");
                servers.add("server4-cluster2");
                servers.add("server5-cluster2");
                break;
            case "cluster3":
                servers.add("server1-cluster3");
                servers.add("server2-cluster3");
                servers.add("server3-cluster3");
                break;
            default:
                // Default cluster with some servers
                servers.add("server1-default");
                servers.add("server2-default");
                servers.add("server3-default");
                break;
        }
        
        return servers;
    }
} 