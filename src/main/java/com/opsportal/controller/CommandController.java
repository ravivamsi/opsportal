package com.opsportal.controller;

import com.opsportal.model.CommandResult;
import com.opsportal.config.SSHConfig;
import com.opsportal.config.WindowsConfig;
import com.opsportal.service.SSHService;
import com.opsportal.service.WindowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commands")
public class CommandController {

    @Autowired
    private SSHService sshService;

    @Autowired
    private WindowsService windowsService;

    @PostMapping("/linux/execute")
    public ResponseEntity<CommandResult> executeLinuxCommand(@RequestParam String serverName,
                                                          @RequestParam String command) {
        CommandResult result = sshService.executeCommand(serverName, command);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/windows/execute")
    public ResponseEntity<CommandResult> executeWindowsCommand(@RequestParam String serverName,
                                                            @RequestParam String command) {
        CommandResult result = windowsService.executeCommand(serverName, command);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/linux/servers")
    public ResponseEntity<List<SSHConfig.SSHServer>> getLinuxServers() {
        List<SSHConfig.SSHServer> servers = sshService.getAvailableServers();
        return ResponseEntity.ok(servers);
    }

    @GetMapping("/windows/servers")
    public ResponseEntity<List<WindowsConfig.WindowsServer>> getWindowsServers() {
        List<WindowsConfig.WindowsServer> servers = windowsService.getAvailableServers();
        return ResponseEntity.ok(servers);
    }
} 