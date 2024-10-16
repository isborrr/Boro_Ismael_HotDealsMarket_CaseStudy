package com.ismaelboro.hotdealsmarket.service;

import com.ismaelboro.hotdealsmarket.model.Cart;
import com.ismaelboro.hotdealsmarket.model.CartItem;
import com.ismaelboro.hotdealsmarket.model.Product;
import com.ismaelboro.hotdealsmarket.model.ReceivingStatus;
import com.ismaelboro.hotdealsmarket.repository.CartItemRepository;
import com.ismaelboro.hotdealsmarket.repository.CartRepository;
import com.ismaelboro.hotdealsmarket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartRepository cartRepository;


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
                    cartItem.setCart(updatedCartItem.getCart());
                    cartItem.setProduct(updatedCartItem.getProduct());
                    cartItem.setQuantity(updatedCartItem.getQuantity());
                    return cartItemRepository.save(cartItem);
                })
                .orElseThrow(() -> new RuntimeException("Card item not found"));
    }

    public List<CartItem> getCartItemsByCustomerId(Long customerId) {
        return cartItemRepository.findByCartCustomerId(customerId);
    }


//    Service for add to a cart and buy now
//
//    public Cart addToCart(Long customerId, Long productId, int quantity, ReceivingStatus status) {
//        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
//
//        Cart cart = cartRepository.findByCustomerId(customerId).orElseGet(() -> {
//            Cart newCart = new Cart();
//            newCart.setCustomerId(customerId);
//            return newCart;
//        });
//
//        CartItem cartItem = new CartItem();
//        cartItem.setProduct(product);
//        cartItem.setQuantity(quantity);
//        cartItem.setCart(cart);
//
//        cart.setReceivingStatus(status);
//        cart.getCartItems().add(cartItem);
//
//        return cartRepository.save(cart);
//    }

}
