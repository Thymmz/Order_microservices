package com.walmart.inventoryquantitychange.dao;

import com.walmart.inventoryquantitychange.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDao extends JpaRepository<Item, Integer> {
}
