package com.opsportal.service;

import com.opsportal.model.ConfigDiffResult;
import com.opsportal.config.GitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class GitService {

    @Autowired
    private GitConfig gitConfig;

    public ConfigDiffResult compareBranches(String repoName, String fileName, String branch1, String branch2) {
        GitConfig.GitRepository repo = findRepositoryByName(repoName);
        if (repo == null) {
            ConfigDiffResult result = new ConfigDiffResult(repoName, fileName, branch1, branch2);
            result.setErrorMessage("Repository not found: " + repoName);
            return result;
        }

        ConfigDiffResult result = new ConfigDiffResult(repoName, fileName, branch1, branch2);

        try {
            // Use git command line to get diff
            ProcessBuilder pb = new ProcessBuilder(
                "git", "diff", branch1 + ".." + branch2, "--", fileName
            );
            pb.directory(new java.io.File(repo.getLocalPath()));
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
            
            if (exitCode == 0) {
                List<String> differences = new ArrayList<>();
                String[] lines = output.toString().split("\n");
                for (String diffLine : lines) {
                    if (!diffLine.trim().isEmpty()) {
                        differences.add(diffLine);
                    }
                }
                result.setDifferences(differences);
            } else {
                result.setErrorMessage("Git diff command failed with exit code: " + exitCode);
            }

        } catch (Exception e) {
            result.setErrorMessage("Git operation failed: " + e.getMessage());
        }

        return result;
    }

    public List<String> getAvailableBranches(String repoName) {
        GitConfig.GitRepository repo = findRepositoryByName(repoName);
        if (repo == null) {
            return new ArrayList<>();
        }

        List<String> branches = new ArrayList<>();
        try {
            ProcessBuilder pb = new ProcessBuilder("git", "branch", "--list", "--format=%(refname:short)");
            pb.directory(new java.io.File(repo.getLocalPath()));
            pb.redirectErrorStream(true);
            
            Process process = pb.start();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    branches.add(line.trim());
                }
            }
            
            process.waitFor();
            
        } catch (Exception e) {
            // Log error but return empty list
        }
        return branches;
    }

    public List<GitConfig.GitRepository> getAvailableRepositories() {
        return gitConfig.getRepositories();
    }

    private GitConfig.GitRepository findRepositoryByName(String repoName) {
        return gitConfig.getRepositories().stream()
                .filter(repo -> repo.getName().equals(repoName))
                .findFirst()
                .orElse(null);
    }
} 