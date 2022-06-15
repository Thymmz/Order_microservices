package com.walmart.inventorycheck.controller;

import com.walmart.inventorycheck.service.InventoryCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/inventory")
public class ItemController {

    @Autowired
    private InventoryCheckService inventoryCheckService;

    public ItemController(InventoryCheckService inventoryCheckService) {
        this.inventoryCheckService = inventoryCheckService;
    }

    @GetMapping("/")
    public String inventoryCheck(@RequestParam(name = "itemId") Integer itemId) throws Exception {
        return inventoryCheckService.inventoryCheck(itemId);
    }
}
