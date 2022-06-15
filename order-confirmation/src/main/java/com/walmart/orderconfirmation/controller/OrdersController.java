package com.walmart.orderconfirmation.controller;
import com.walmart.orderconfirmation.service.OrderConfirmationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {

    @Autowired
    private OrderConfirmationService orderConfirmationService;

    public OrdersController(OrderConfirmationService orderConfirmationService) {
        this.orderConfirmationService = orderConfirmationService;
    }

    @GetMapping("/")
    public String getConfirmationStatus(@RequestParam(name = "ordersId") Integer ordersId){
        return orderConfirmationService.confirmOrder(ordersId);
    }

}
