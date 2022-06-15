package com.walmart.invoicecreate.controller;

import com.walmart.invoicecreate.service.InvoiceCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/invoice")
public class OrdersController {

    @Autowired
    private InvoiceCreateService invoiceCreateService;

    public OrdersController(InvoiceCreateService invoiceCreateService) {
        this.invoiceCreateService = invoiceCreateService;
    }

    @GetMapping("/")
    public Integer createInvoice(@RequestParam(name = "ordersId") Integer ordersId){
        return invoiceCreateService.invoiceCreate(ordersId);
    }
}
