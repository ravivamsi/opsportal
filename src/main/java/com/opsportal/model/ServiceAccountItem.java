package com.opsportal.model;

public class ServiceAccountItem {
    private String appname;
    private String saname;
    private String saexpirydate;
    private String lastrotation;

    // Default constructor
    public ServiceAccountItem() {}

    // Getters and Setters
    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getSaname() {
        return saname;
    }

    public void setSaname(String saname) {
        this.saname = saname;
    }

    public String getSaexpirydate() {
        return saexpirydate;
    }

    public void setSaexpirydate(String saexpirydate) {
        this.saexpirydate = saexpirydate;
    }

    public String getLastrotation() {
        return lastrotation;
    }

    public void setLastrotation(String lastrotation) {
        this.lastrotation = lastrotation;
    }
} 