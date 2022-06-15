package com.walmart.payment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    private Integer userId;

    @Column(name = "creditCardnumber", length = 16, nullable = false)
    private Integer creditCardNumber;
}
