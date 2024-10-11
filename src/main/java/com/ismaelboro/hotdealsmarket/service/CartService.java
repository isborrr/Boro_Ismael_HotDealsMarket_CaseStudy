package com.ismaelboro.hotdealsmarket.service;


import com.ismaelboro.hotdealsmarket.model.Cart;
import com.ismaelboro.hotdealsmarket.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<Cart> getAllCarts(){
        return cartRepository.findAll();
    }

    public Optional<Cart> getCartById(Long id){
        return cartRepository.findById(id);
    }

    public Cart createCart(Cart cart){
        return cartRepository.save(cart);
    }

    public void deleteCart(Long id){
        cartRepository.deleteById(id);
    }

    public Cart updateCart(Long id, Cart updatedCart) {
        return cartRepository.findById(id)
                .map(cart -> {
                    cart.setCartItems(updatedCart.getCartItems());
                    cart.setCustomerId(updatedCart.getCustomerId());
                    cart.setReceivingStatus(updatedCart.getReceivingStatus());
                    return cartRepository.save(cart);
                })
                .orElseThrow(() -> new RuntimeException("Card not found"));
    }
}
