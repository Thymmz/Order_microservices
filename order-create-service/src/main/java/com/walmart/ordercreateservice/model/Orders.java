package com.walmart.ordercreateservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ordersId", length = 1, unique = true, nullable = false)
    private Integer ordersId;

    @Column(name = "itemId", nullable = false)
    private Integer itemId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "confirmationStatus", nullable = false)
    private String confirmationStatus;

    @Column(name = "address")
    private String address;
}


