package com.opsportal.service;

import com.opsportal.model.CommandResult;
import com.opsportal.config.WindowsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class WindowsService {

    @Autowired
    private WindowsConfig windowsConfig;

    public CommandResult executeCommand(String serverName, String command) {
        WindowsConfig.WindowsServer server = findServerByName(serverName);
        if (server == null) {
            CommandResult result = new CommandResult(serverName, command);
            result.setError("Server not found: " + serverName);
            result.setExitCode(-1);
            return result;
        }

        long startTime = System.currentTimeMillis();
        CommandResult result = new CommandResult(serverName, command);

        try {
            // Using PowerShell to execute commands remotely
            String psCommand = String.format(
                "Invoke-Command -ComputerName %s -Credential (Get-Credential -UserName %s -Message 'Enter credentials') -ScriptBlock { %s }",
                server.getHost(),
                server.getUsername(),
                command
            );

            ProcessBuilder pb = new ProcessBuilder("powershell", "-Command", psCommand);
            pb.redirectErrorStream(true);
            
            Process process = pb.start();
            
            // Read output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            
            int exitCode = process.waitFor();
            
            result.setOutput(output.toString());
            result.setExitCode(exitCode);
            
            if (exitCode != 0) {
                result.setError("Command failed with exit code: " + exitCode);
            }

        } catch (Exception e) {
            result.setError("Windows command execution error: " + e.getMessage());
            result.setExitCode(-1);
        }

        result.setExecutionTime(System.currentTimeMillis() - startTime);
        return result;
    }

    public List<WindowsConfig.WindowsServer> getAvailableServers() {
        return windowsConfig.getServers();
    }

    private WindowsConfig.WindowsServer findServerByName(String serverName) {
        return windowsConfig.getServers().stream()
                .filter(server -> server.getName().equals(serverName))
                .findFirst()
                .orElse(null);
    }
} 