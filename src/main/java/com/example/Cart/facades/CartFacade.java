package com.example.Cart.facades;

import com.example.Cart.dtos.requests.CartRequestDTO;
import com.example.Cart.dtos.responses.CartResponseDTO;

public interface CartFacade {

    CartResponseDTO addProduct(CartRequestDTO cartRequestDTO);
}
