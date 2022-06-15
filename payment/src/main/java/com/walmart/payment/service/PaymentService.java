package com.walmart.payment.service;

import com.walmart.payment.dao.PaymentDao;
import com.walmart.payment.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    public PaymentService(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    public String paymentCheck(Integer itemId){
        Optional<Payment> item = paymentDao.findById(itemId);
        Integer creditCardNumber = item.get().getCreditCardNumber();
        if(creditCardNumber > 0){
            return "Item present in inventory";
        }
        else{
            return "Payment information does not exist";
        }
    }
}
