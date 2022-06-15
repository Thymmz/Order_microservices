package com.walmart.ordervalidationservice.controller;

import com.walmart.ordervalidationservice.service.OrderValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ordersValidation")
public class OrdersContoller {

    @Autowired
    private OrderValidationService orderValidationService;

    public OrdersContoller(OrderValidationService orderValidationService) {
        this.orderValidationService = orderValidationService;
    }

    @GetMapping("/")
    public String validateOrder(@RequestParam(name = "ordersId") Integer ordersId){
        return orderValidationService.validateOrder(ordersId);
    }
}
