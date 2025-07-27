package com.opsportal.model;

public class KafkaItem {
    private String appName;
    private String topicName;
    private String certSaName;
    private String permissions;

    // Default constructor
    public KafkaItem() {}

    public KafkaItem(String appName, String topicName, String certSaName, String permissions) {
        this.appName = appName;
        this.topicName = topicName;
        this.certSaName = certSaName;
        this.permissions = permissions;
    }

    // Getters and Setters
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getCertSaName() {
        return certSaName;
    }

    public void setCertSaName(String certSaName) {
        this.certSaName = certSaName;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
} 