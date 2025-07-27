package com.opsportal.model;

import java.time.LocalDateTime;
import java.util.List;

public class ConfigDiffResult {
    private String repositoryName;
    private String fileName;
    private String branch1;
    private String branch2;
    private String diff;
    private int diffCount;
    private List<String> differences;
    private LocalDateTime timestamp;
    private String errorMessage;

    public ConfigDiffResult() {}

    public ConfigDiffResult(String repositoryName, String fileName, String branch1, String branch2) {
        this.repositoryName = repositoryName;
        this.fileName = fileName;
        this.branch1 = branch1;
        this.branch2 = branch2;
        this.timestamp = LocalDateTime.now();
    }

    public ConfigDiffResult(String repositoryName, String fileName, String branch1, String branch2, String diff, int diffCount) {
        this.repositoryName = repositoryName;
        this.fileName = fileName;
        this.branch1 = branch1;
        this.branch2 = branch2;
        this.diff = diff;
        this.diffCount = diffCount;
        this.timestamp = LocalDateTime.now();
    }

    // Getters and Setters
    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getBranch1() {
        return branch1;
    }

    public void setBranch1(String branch1) {
        this.branch1 = branch1;
    }

    public String getBranch2() {
        return branch2;
    }

    public void setBranch2(String branch2) {
        this.branch2 = branch2;
    }

    public String getDiff() {
        return diff;
    }

    public void setDiff(String diff) {
        this.diff = diff;
    }

    public int getDiffCount() {
        return diffCount;
    }

    public void setDiffCount(int diffCount) {
        this.diffCount = diffCount;
    }

    public List<String> getDifferences() {
        return differences;
    }

    public void setDifferences(List<String> differences) {
        this.differences = differences;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
} 