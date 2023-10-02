package com.example.Cart.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("orders")
public class CartEntity {

    private String name;
    private List<ItemsEntity> items;
    private List<FriendsEntity> friends;
    private double discounts;
    private double value;
    private double price;
    private double delivery;
    private double valueTotal;

    private double deliveryFee;
    private double discountsFee;

}
