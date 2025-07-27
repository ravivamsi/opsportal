package com.opsportal.model;

public class CertificateItem {
    private String appname;
    private String certname;
    private String certexpirydate;
    private String lastrotation;

    // Default constructor
    public CertificateItem() {}

    // Getters and Setters
    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getCertname() {
        return certname;
    }

    public void setCertname(String certname) {
        this.certname = certname;
    }

    public String getCertexpirydate() {
        return certexpirydate;
    }

    public void setCertexpirydate(String certexpirydate) {
        this.certexpirydate = certexpirydate;
    }

    public String getLastrotation() {
        return lastrotation;
    }

    public void setLastrotation(String lastrotation) {
        this.lastrotation = lastrotation;
    }
} 