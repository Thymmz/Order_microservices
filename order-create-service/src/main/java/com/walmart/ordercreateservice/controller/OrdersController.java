package com.walmart.ordercreateservice.controller;

import com.walmart.ordercreateservice.model.Orders;
import com.walmart.ordercreateservice.service.OrdersCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orders")
public class OrdersController {

    @Autowired
    private OrdersCreateService ordersCreateService;

    public OrdersController(OrdersCreateService ordersCreateService) {
        this.ordersCreateService = ordersCreateService;
    }

    @PostMapping(path = "/", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public String saveOrder(@RequestBody Orders orders){

        return ordersCreateService.saveOrder(new Orders(orders.getOrdersId(), orders.getItemId(), orders.getQuantity(), orders.getAmount(), orders.getConfirmationStatus(), orders.getAddress()));
    }
}
