package com.walmart.orderconfirmation.service;

import com.walmart.orderconfirmation.dao.OrdersDao;
import com.walmart.orderconfirmation.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderConfirmationService {

    @Autowired
    private OrdersDao ordersDao;

    public OrderConfirmationService(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }

    public String confirmOrder(Integer ordersId){
        Optional<Orders> orders = ordersDao.findById(ordersId);
        String confirmationStatus = orders.get().getConfirmationStatus();
        if(confirmationStatus.equals("Confirmed")){
            return "Order Confirmed";
        }
        else if(confirmationStatus.equals("NotConfirmed")){
            return "Order not confirmed";
        }
        else{
            throw new RuntimeException("No such order exists");
        }
    }

}
