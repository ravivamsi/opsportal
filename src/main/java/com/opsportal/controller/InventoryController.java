package com.opsportal.controller;

import com.opsportal.model.InventoryItem;
import com.opsportal.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/data")
    public List<InventoryItem> getInventoryData() {
        return inventoryService.loadInventoryData();
    }
} 