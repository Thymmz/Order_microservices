package com.walmart.inventorycheck.service;

import com.walmart.inventorycheck.dao.ItemDao;
import com.walmart.inventorycheck.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryCheckService {

    @Autowired
    private ItemDao itemDao;

    public InventoryCheckService(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public String inventoryCheck(Integer itemId) throws Exception {
        Optional<Item> item = Optional.ofNullable(itemDao.findById(itemId).orElseThrow(() -> new Exception("Item not present in Inventory")));
        Integer quantity = item.get().getQuantity();

        if(item.isPresent() && quantity > 0){
            return "Item present in inventory";
        }
        else{
            return "Item not present in inventory";
        }
    }

}
