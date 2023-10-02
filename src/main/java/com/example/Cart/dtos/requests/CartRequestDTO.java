package com.example.Cart.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartRequestDTO {

    @NotEmpty(message = "{not.empty}")
    @NotBlank(message = "{not.blank}")
    private String name;
    private List<ItemRequestDTO> items;
    private List<FriendRequestDTO> friends;
}
