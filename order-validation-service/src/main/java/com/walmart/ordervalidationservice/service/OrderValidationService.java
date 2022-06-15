package com.walmart.ordervalidationservice.service;

import com.walmart.ordervalidationservice.dao.OrdersDao;
import com.walmart.ordervalidationservice.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class OrderValidationService {
    @Autowired
    private OrdersDao ordersDao;


    public OrderValidationService(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }


    public String validateOrder(Integer ordersId){
        Optional<Orders> orders = ordersDao.findById(ordersId);
        if(orders.isPresent()){
            return "Valid Order";
        }
        else {
            return "Order not present";
        }
    }

}
