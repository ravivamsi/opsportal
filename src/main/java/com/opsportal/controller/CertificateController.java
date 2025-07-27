package com.opsportal.controller;

import com.opsportal.model.CertificateItem;
import com.opsportal.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/certificate")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    @GetMapping("/data")
    public List<CertificateItem> getCertificateData() {
        return certificateService.loadCertificateData();
    }
} 