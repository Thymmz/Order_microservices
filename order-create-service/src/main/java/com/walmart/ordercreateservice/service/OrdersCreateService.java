package com.walmart.ordercreateservice.service;

import com.walmart.ordercreateservice.dao.OrdersDao;
import com.walmart.ordercreateservice.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrdersCreateService {

    @Autowired
    private OrdersDao ordersDao;

    @Autowired
    private RestTemplate restTemplate;

    public OrdersCreateService(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }

    public String saveOrder(Orders orders){
        String inventoryCheck = checkInventoryBeforeOrder(orders.getItemId());
        if(inventoryCheck.equals("Item present in inventory")){
            ordersDao.save(orders);
            inventoryQuantity(orders.getItemId());
            return "Order Created";
        }
        else{
            return "Item not available in the inventory please try again later";
        }
    }

    public String checkInventoryBeforeOrder(Integer itemId){
        String inventoryCheck = restTemplate.getForObject("http://localhost:9004/api/v1/inventory/?itemId="+itemId, String.class);
        return inventoryCheck;
    }

    public void inventoryQuantity(Integer itemId){
        Integer changedQuantity = restTemplate.getForObject("http://localhost:9008/api/v1/inventoryQuantity/?itemId="+itemId, Integer.class);
    }
}
