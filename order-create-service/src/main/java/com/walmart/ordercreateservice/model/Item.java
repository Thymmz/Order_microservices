package com.walmart.ordercreateservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    private Integer itemId;

    private Integer quantity;

    private String productName;

    private Integer amount;
}
