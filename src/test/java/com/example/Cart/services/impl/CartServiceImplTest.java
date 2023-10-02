package com.example.Cart.services.impl;

import com.example.Cart.entities.CartEntity;
import com.example.Cart.entities.FriendsEntity;
import com.example.Cart.entities.ItemsEntity;
import com.example.Cart.entities.ItemsFriendsEntity;
import com.example.Cart.repositories.CartRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CartServiceImplTest {

    @InjectMocks
    private CartServiceImpl cartService;

    @Mock
    private CartRepository cartRepository;

    CartEntity cartEntity;

    @BeforeEach
    void setUp() {
        List<ItemsEntity> items = new ArrayList<>();
        ItemsEntity itemsEntity = new ItemsEntity("hot dog", 1, 10.0);
        items.add(itemsEntity);

        List<FriendsEntity> friends = new ArrayList<>();
        List<ItemsFriendsEntity> itemsFriends = new ArrayList<>();
        ItemsFriendsEntity itemsFriendsEntity = new ItemsFriendsEntity("refrigerante", 1, 10);
        itemsFriends.add(itemsFriendsEntity);
        FriendsEntity friendsEntity = new FriendsEntity("Julia", itemsFriends, 10.0, 2, 3, 0.8, 20.0);
        friends.add(friendsEntity);

        cartEntity = new CartEntity("Jorge", items, friends, 2.0, 20.0, 50.0, 5.0, 75.0, 2.0, 2.0);
    }

    @Test
    void addProductSuccess() {
        when(cartRepository.save(cartEntity)).thenReturn(cartEntity);
        CartEntity cart = cartService.addProduct(cartEntity);

        Assertions.assertEquals(cartEntity, cart);
        Assertions.assertNotNull(cart);
        verifyNoMoreInteractions(cartRepository);
    }
}