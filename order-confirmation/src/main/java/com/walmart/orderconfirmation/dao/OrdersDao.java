package com.walmart.orderconfirmation.dao;

import com.walmart.orderconfirmation.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersDao extends JpaRepository<Orders, Integer> {
}
