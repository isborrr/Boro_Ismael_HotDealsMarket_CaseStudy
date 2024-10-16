
package com.ismaelboro.hotdealsmarket.service;


import com.ismaelboro.hotdealsmarket.model.Cart;
import com.ismaelboro.hotdealsmarket.model.CartItem;
import com.ismaelboro.hotdealsmarket.model.Product;
import com.ismaelboro.hotdealsmarket.model.ReceivingStatus;
import com.ismaelboro.hotdealsmarket.repository.CartRepository;
import com.ismaelboro.hotdealsmarket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;
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



//    Service for add to a cart and buy now

    public Cart addToCart(Long customerId, Long productId, ReceivingStatus status) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        //hard coded quantity
        if (status == ReceivingStatus.Shipped){
                 product.setStockQuantity(product.getStockQuantity() -1);
                 productService.updateProduct(productId,product );
            }
        int quantity =1;

        Cart cart = new Cart();
        cart.setCustomerId(customerId); // Set customerId to avoid null issue
//        Cart cart = cartRepository.findByCustomerId(customerId).orElseGet(() -> {
//            Cart newCart = new Cart();
//            newCart.setCustomerId(customerId);
//            return newCart;
//        });

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItem.setCart(cart);

        cart.setReceivingStatus(status);
        List <CartItem> cartItems = new ArrayList<>();
        cartItems.add(cartItem);
//        cart.getCartItems().add(cartItem);
        cart.setCartItems(cartItems);

        return cartRepository.save(cart);
    }
}
