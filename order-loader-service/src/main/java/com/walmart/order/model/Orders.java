package com.walmart.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders implements Serializable {
    @Id
    @Column(name = "ordersId", length = 1, unique = true, nullable = false)
    private Integer ordersId;

    @Column(name = "itemId")
    private Integer itemId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "confirmationStatus")
    private String confirmationStatus;

    @Column(name = "address")
    private String address;
}
