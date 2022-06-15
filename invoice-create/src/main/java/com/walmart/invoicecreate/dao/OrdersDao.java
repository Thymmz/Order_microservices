package com.walmart.invoicecreate.dao;

import com.walmart.invoicecreate.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersDao extends JpaRepository<Orders, Integer> {
}
