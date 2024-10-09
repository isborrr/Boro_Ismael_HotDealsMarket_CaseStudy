package com.ismaelboro.hotdealsmarket.service;

import com.ismaelboro.hotdealsmarket.model.CartItem;
import com.ismaelboro.hotdealsmarket.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;

    public List<CartItem> getAllCartItems(){
        return cartItemRepository.findAll();
    }

    public Optional<CartItem> getCartItemById(Long id){
        return cartItemRepository.findById(id);
    }

    public CartItem createCartItem(CartItem cartItem){
        return cartItemRepository.save(cartItem);
    }

    public void deleteCartItem(Long id){
        cartItemRepository.deleteById(id);
    }

    public CartItem updateCartItem(Long id, CartItem updatedCartItem) {
        return cartItemRepository.findById(id)
                .map(cartItem -> {
                    cartItem.setCustomerCart(updatedCartItem.getCustomerCart());
                    cartItem.setProduct(updatedCartItem.getProduct());
                    cartItem.setQuantity(updatedCartItem.getQuantity());
                    return cartItemRepository.save(cartItem);
                })
                .orElseThrow(() -> new RuntimeException("Card item not found"));
    }

}
