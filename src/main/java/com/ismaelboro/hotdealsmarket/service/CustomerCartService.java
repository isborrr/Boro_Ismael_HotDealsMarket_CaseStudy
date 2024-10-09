package com.ismaelboro.hotdealsmarket.service;


import com.ismaelboro.hotdealsmarket.model.BasicUser;
import com.ismaelboro.hotdealsmarket.model.CustomerCart;
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
    public List<CustomerCart> getAllCustomerCart(){
        return customerCartRepository.findAll();
    }

    public Optional<CustomerCart> getCustomerCartById(Long id){
        return customerCartRepository.findById(id);
    }

    public CustomerCart createCustomerCart(CustomerCart customerCart){
        return customerCartRepository.save(customerCart);
    }

    public void deleteCustomerCart(Long id){
        customerCartRepository.deleteById(id);
    }

    public CustomerCart updateCustomerCart(Long id, CustomerCart updatedCustomerCart) {
        return customerCartRepository.findById(id)
                .map(customerCart -> {
                    customerCart.setCustomerId(updatedCustomerCart.getCustomerId());
                    customerCart.setReceivingStatus(updatedCustomerCart.getReceivingStatus());
                    return customerCartRepository.save(customerCart);
                })
                .orElseThrow(() -> new RuntimeException("Customer card not found"));
    }

}
