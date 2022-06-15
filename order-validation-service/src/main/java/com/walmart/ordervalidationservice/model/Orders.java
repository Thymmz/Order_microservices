package com.walmart.ordervalidationservice.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
