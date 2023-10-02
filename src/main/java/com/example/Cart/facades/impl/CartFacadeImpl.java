package com.example.Cart.facades.impl;

import com.example.Cart.dtos.requests.CartRequestDTO;
import com.example.Cart.dtos.requests.FriendRequestDTO;
import com.example.Cart.dtos.requests.ItemRequestDTO;
import com.example.Cart.dtos.requests.ItemsFriendsRequestDTO;
import com.example.Cart.dtos.responses.CartResponseDTO;
import com.example.Cart.entities.*;
import com.example.Cart.facades.CartFacade;
import com.example.Cart.services.CartService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class CartFacadeImpl implements CartFacade {

    @Autowired
    private CartService cartService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CartResponseDTO addProduct(CartRequestDTO cartRequestDTO) {
        return convertCartEntityToCartResponseDTO(cartService.addProduct(convertCartRequestDTOToCartEntity(cartRequestDTO)));
    }

    private CartEntity convertCartRequestDTOToCartEntity(CartRequestDTO cartRequestDTO) {
        CartEntity cartEntity = new CartEntity();

        cartEntity.setDeliveryFee(5.0);
        cartEntity.setDiscountsFee(2.0);

        cartEntity.setName(cartRequestDTO.getName());

        List<ItemsEntity> itemsEntityList = new ArrayList<>();
        List<ItemRequestDTO> items = cartRequestDTO.getItems();
        for (ItemRequestDTO itemRequestDTO : items) {
            ItemsEntity itemsEntity = new ItemsEntity();
            itemsEntity.setProductName(itemRequestDTO.getProductName());
            itemsEntity.setQuantity(itemRequestDTO.getQuantity());
            itemsEntity.setUnitaryValue(itemRequestDTO.getUnitaryValue());
            itemsEntityList.add(itemsEntity);
            cartEntity.setItems(itemsEntityList);

            cartEntity.setValue(itemRequestDTO.getQuantity() * itemRequestDTO.getUnitaryValue()
                    + cartEntity.getDelivery() - cartEntity.getDiscounts());
        }

        List<FriendsEntity> friendsEntityList = new ArrayList<>();
        List<FriendRequestDTO> friendRequestDTOList = cartRequestDTO.getFriends();
        for (FriendRequestDTO friendRequestDTO : friendRequestDTOList) {
            FriendsEntity friendsEntity = new FriendsEntity();
            friendsEntity.setName(friendRequestDTO.getName());
            friendsEntityList.add(friendsEntity);
            cartEntity.setFriends(friendsEntityList);

            List<ItemsFriendsRequestDTO> itemsFriends = friendRequestDTO.getItemsFriends();
            for (ItemsFriendsRequestDTO itemRequestDTO : itemsFriends) {
                ItemsFriendsEntity itemsFriendsEntity = new ItemsFriendsEntity();
                List<ItemsFriendsEntity> itemsFriendsEntityList = new ArrayList<>();

                itemsFriendsEntity.setProductName(itemRequestDTO.getProductName());
                itemsFriendsEntity.setQuantity(itemRequestDTO.getQuantity());
                itemsFriendsEntity.setUnitaryValue(itemRequestDTO.getUnitaryValue());
                itemsFriendsEntityList.add(itemsFriendsEntity);
                friendsEntity.setItemsFriends(itemsFriendsEntityList);

                double result;
                friendsEntity.setProportion(friendsEntity.getValue() / cartEntity.getValue());
                friendsEntity.setDelivery(cartEntity.getDeliveryFee() * friendsEntity.getProportion());
                friendsEntity.setDiscounts(cartEntity.getDiscountsFee() * friendsEntity.getProportion());

                result = (itemRequestDTO.getUnitaryValue() * itemRequestDTO.getQuantity());
                friendsEntity.setValue(result);

                friendsEntity.setValueTotal(friendsEntity.getValue() + friendsEntity.getDelivery() - friendsEntity.getDiscounts());
            }

            cartEntity.setDiscounts(cartEntity.getDiscountsFee() - friendsEntity.getDiscounts());
            cartEntity.setDelivery(cartEntity.getDeliveryFee() - friendsEntity.getDelivery());
            cartEntity.setValueTotal(cartEntity.getValue() + friendsEntity.getValueTotal());
            cartEntity.setPrice(cartEntity.getValue() + cartEntity.getDelivery() - cartEntity.getDiscounts());
        }
        return cartEntity;
    }

    private CartResponseDTO convertCartEntityToCartResponseDTO(CartEntity cartEntity) {
        CartResponseDTO cartResponseDTO = new CartResponseDTO();
        cartResponseDTO.setUrl("https://picpay.com/");
        return cartResponseDTO;
    }
}
