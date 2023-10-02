package com.example.Cart.entities;

import com.example.Cart.dtos.requests.ItemRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendsEntity {

    private String name;
    private List<ItemsFriendsEntity> itemsFriends;
    private double value;
    private double delivery;
    private double discounts;
    private double proportion;

    private double valueTotal;
}
