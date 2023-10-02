package com.example.Cart.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendRequestDTO {

    private String name;
    private List<ItemsFriendsRequestDTO> itemsFriends;
}
