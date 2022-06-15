package com.walmart.inventoryquantitychange.controller;

import com.walmart.inventoryquantitychange.service.InventoryQuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/inventoryQuantity")
public class ItemController {

    @Autowired
    private InventoryQuantityService inventoryQuantityService;

    public ItemController(InventoryQuantityService inventoryQuantityService) {
        this.inventoryQuantityService = inventoryQuantityService;
    }

    @GetMapping("/")
    public Integer inventoryCheck(@RequestParam(name = "itemId") Integer itemId){
        return inventoryQuantityService.changeInventoryQuantity(itemId);
    }

}
