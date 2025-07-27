package com.opsportal.service;

import com.opsportal.model.CommandResult;
import com.opsportal.config.SSHConfig;
import com.jcraft.jsch.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

@Service
public class SSHService {

    @Autowired
    private SSHConfig sshConfig;

    public CommandResult executeCommand(String serverName, String command) {
        SSHConfig.SSHServer server = findServerByName(serverName);
        if (server == null) {
            CommandResult result = new CommandResult(serverName, command);
            result.setError("Server not found: " + serverName);
            result.setExitCode(-1);
            return result;
        }

        long startTime = System.currentTimeMillis();
        CommandResult result = new CommandResult(serverName, command);

        JSch jsch = new JSch();
        Session session = null;
        ChannelExec channel = null;

        try {
            // Add private key if specified
            if (server.getKeyPath() != null && !server.getKeyPath().isEmpty()) {
                jsch.addIdentity(server.getKeyPath());
            }

            session = jsch.getSession(server.getUsername(), server.getHost(), server.getPort());
            session.setConfig("StrictHostKeyChecking", "no");
            session.setTimeout(sshConfig.getDefaultTimeout());
            session.connect();

            channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand(command);

            ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
            ByteArrayOutputStream errorStream = new ByteArrayOutputStream();

            channel.setOutputStream(responseStream);
            channel.setErrStream(errorStream);

            channel.connect();

            // Wait for the command to complete
            while (channel.isConnected()) {
                Thread.sleep(100);
            }

            result.setOutput(responseStream.toString());
            result.setError(errorStream.toString());
            result.setExitCode(channel.getExitStatus());

        } catch (Exception e) {
            result.setError("SSH execution error: " + e.getMessage());
            result.setExitCode(-1);
        } finally {
            if (channel != null) {
                channel.disconnect();
            }
            if (session != null) {
                session.disconnect();
            }
        }

        result.setExecutionTime(System.currentTimeMillis() - startTime);
        return result;
    }

    public List<SSHConfig.SSHServer> getAvailableServers() {
        return sshConfig.getServers();
    }

    private SSHConfig.SSHServer findServerByName(String serverName) {
        return sshConfig.getServers().stream()
                .filter(server -> server.getName().equals(serverName))
                .findFirst()
                .orElse(null);
    }


} 