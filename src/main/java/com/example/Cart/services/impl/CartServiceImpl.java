package com.example.Cart.services.impl;

import com.example.Cart.entities.CartEntity;
import com.example.Cart.repositories.CartRepository;
import com.example.Cart.services.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public CartEntity addProduct(CartEntity cartEntity) {
        log.info("add products to cart {}", cartEntity);
        return cartRepository.save(cartEntity);
    }
}
