package com.walmart.invoicecreate.service;

import com.walmart.invoicecreate.dao.OrdersDao;
import com.walmart.invoicecreate.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvoiceCreateService {

    @Autowired
    private OrdersDao ordersDao;

    public InvoiceCreateService(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }

    public Integer invoiceCreate(Integer ordersId){
        Optional<Orders> orders = ordersDao.findById(ordersId);
        Integer quantity = orders.get().getQuantity();
        Integer amount = orders.get().getAmount();
        return quantity*amount;
    }
}
