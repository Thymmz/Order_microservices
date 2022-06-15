package com.walmart.orderconfirmation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    private Integer ordersId;
    private Integer itemId;
    private Integer quantity;
    private Integer amount;
    private String confirmationStatus;
    private String address;
}
