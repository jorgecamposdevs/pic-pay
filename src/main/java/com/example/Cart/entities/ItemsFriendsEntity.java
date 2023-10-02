package com.example.Cart.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemsFriendsEntity {

    private String productName;
    private int quantity;
    private double unitaryValue;
}
