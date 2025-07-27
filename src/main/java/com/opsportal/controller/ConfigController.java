package com.opsportal.controller;

import com.opsportal.model.ConfigDiffResult;
import com.opsportal.config.GitConfig;
import com.opsportal.service.GitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/config")
public class ConfigController {

    @Autowired
    private GitService gitService;

    @PostMapping("/diff")
    public ResponseEntity<ConfigDiffResult> compareBranches(@RequestParam String repoName,
                                                          @RequestParam String fileName,
                                                          @RequestParam String branch1,
                                                          @RequestParam String branch2) {
        ConfigDiffResult result = gitService.compareBranches(repoName, fileName, branch1, branch2);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/repositories")
    public ResponseEntity<List<GitConfig.GitRepository>> getRepositories() {
        List<GitConfig.GitRepository> repositories = gitService.getAvailableRepositories();
        return ResponseEntity.ok(repositories);
    }

    @GetMapping("/branches/{repoName}")
    public ResponseEntity<List<String>> getBranches(@PathVariable String repoName) {
        List<String> branches = gitService.getAvailableBranches(repoName);
        return ResponseEntity.ok(branches);
    }
} 