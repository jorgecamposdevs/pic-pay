package com.example.Cart.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemRequestDTO {

    private String productName;
    private int quantity;
    private double unitaryValue;
}
