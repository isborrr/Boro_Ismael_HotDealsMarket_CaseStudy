package com.ismaelboro.hotdealsmarket.controller;


import com.ismaelboro.hotdealsmarket.model.Cart;
import com.ismaelboro.hotdealsmarket.model.Product;
import com.ismaelboro.hotdealsmarket.service.CartService;
import com.ismaelboro.hotdealsmarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable Long id) {
        Optional<Cart> cart = cartService.getCartById(id);
        return cart.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
        Cart createdCart = cartService.createCart(cart);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCart);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable Long id, @RequestBody Cart updatedCart) {
        Cart cart = cartService.updateCart(id, updatedCart);
        return ResponseEntity.ok(cart);
    }
    //note fron intructor
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
        return new ResponseEntity<>("Cart has been deleted ",HttpStatus.OK);
//        return ResponseEntity.noContent().build();  // HTTP 204 No Content   // from instructor
    }
}
