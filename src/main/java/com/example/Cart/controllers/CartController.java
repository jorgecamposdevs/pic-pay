package com.example.Cart.controllers;

import com.example.Cart.dtos.requests.CartRequestDTO;
import com.example.Cart.dtos.responses.CartResponseDTO;
import com.example.Cart.facades.CartFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/carts")
public class CartController {

    @Autowired
    private CartFacade cartFacade;

    @Operation(summary = "add product cart")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "add product cart"),
            @ApiResponse(responseCode = "400", description = "bad request")
    })
    @PostMapping
    public ResponseEntity<CartResponseDTO> addProduct(@Valid @RequestBody CartRequestDTO cartRequestDTO) {
        return new ResponseEntity<>(cartFacade.addProduct(cartRequestDTO), HttpStatus.CREATED);
    }
}
