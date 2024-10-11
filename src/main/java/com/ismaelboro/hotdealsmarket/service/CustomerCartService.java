package com.ismaelboro.hotdealsmarket.service;


import com.ismaelboro.hotdealsmarket.model.Cart;
import com.ismaelboro.hotdealsmarket.repository.CustomerCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerCartService {
    @Autowired
    private CustomerCartRepository customerCartRepository;

    //return a list containing all the customer carts
    public List<Cart> getAllCustomerCart(){
        return customerCartRepository.findAll();
    }

    public Optional<Cart> getCustomerCartById(Long id){
        return customerCartRepository.findById(id);
    }

    public Cart createCustomerCart(Cart customerCart){
        return customerCartRepository.save(customerCart);
    }

    public void deleteCustomerCart(Long id){
        customerCartRepository.deleteById(id);
    }

    public Cart updateCustomerCart(Long id, Cart updatedCustomerCart) {
        return customerCartRepository.findById(id)
                .map(customerCart -> {
                    customerCart.setCustomerId(updatedCustomerCart.getCustomerId());
                    customerCart.setReceivingStatus(updatedCustomerCart.getReceivingStatus());
                    return customerCartRepository.save(customerCart);
                })
                .orElseThrow(() -> new RuntimeException("Customer card not found"));
    }

}
