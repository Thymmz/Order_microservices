package com.walmart.order.controller;


import com.walmart.order.model.Orders;
import com.walmart.order.service.OrderLoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/orderloader")
public class OrderLoaderController {

    @Autowired
    private OrderLoaderService orderLoaderService;

    public OrderLoaderController(OrderLoaderService orderLoaderService) {
        this.orderLoaderService = orderLoaderService;
    }


    @GetMapping("/")
    public void loadXml() throws IOException, ParserConfigurationException, SAXException {
        orderLoaderService.parseAndSave("src/main/resources/xmlfile/Orders.xml");
    }
//
//    @PostMapping("/")
//    public Orders saveOrders(@RequestBody Orders orders){
//        return orderLoaderService.saveOrder(orders);
//    }
//
//    @GetMapping("/{id}")
//    public Orders getOrderById(@PathVariable("id") Integer id){
//        return orderLoaderService.getOrderById(id);
//    }

}
