package com.walmart.ordervalidationservice.dao;

import com.walmart.ordervalidationservice.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersDao extends JpaRepository<Orders, Integer> {
}
