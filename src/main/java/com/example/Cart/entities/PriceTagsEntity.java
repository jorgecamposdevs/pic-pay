package com.example.Cart.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceTagsEntity {

    private double discounts;
    private double delivery;
}
