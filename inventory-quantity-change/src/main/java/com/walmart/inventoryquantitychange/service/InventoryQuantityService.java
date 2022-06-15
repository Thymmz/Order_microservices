package com.walmart.inventoryquantitychange.service;

import com.walmart.inventoryquantitychange.dao.ItemDao;
import com.walmart.inventoryquantitychange.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryQuantityService {

    @Autowired
    private ItemDao itemDao;

    public InventoryQuantityService(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public Integer changeInventoryQuantity(Integer itemId){
        Optional<Item> item = itemDao.findById(itemId);
        Integer presesntQuantity = item.get().getQuantity();
        presesntQuantity = presesntQuantity - 1;
        item.get().setQuantity(presesntQuantity);
        itemDao.save(item.get());
        return item.get().getQuantity();
    }


}
