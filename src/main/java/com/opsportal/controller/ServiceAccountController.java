package com.opsportal.controller;

import com.opsportal.model.ServiceAccountItem;
import com.opsportal.service.ServiceAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/service-accounts")
public class ServiceAccountController {

    @Autowired
    private ServiceAccountService serviceAccountService;

    @GetMapping("/data")
    public List<ServiceAccountItem> getServiceAccountData() {
        return serviceAccountService.loadServiceAccountData();
    }
} 