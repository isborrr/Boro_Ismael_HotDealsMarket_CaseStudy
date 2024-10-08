package com.ismaelboro.hotdealsmarket.service;

import com.ismaelboro.hotdealsmarket.model.BasicUser;
import com.ismaelboro.hotdealsmarket.repository.BasicUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BasicUserService {
    @Autowired
    private BasicUserRepository basicUserRepository;
    @Autowired
    private UserDetailsServiceAutoConfiguration userDetailsServiceAutoConfiguration;

    public List<BasicUser> getAllUsers(){
        return basicUserRepository.findAll();
    }

    public Optional<BasicUser> getUserById(Long id){
        return basicUserRepository.findById(id);
    }

    public BasicUser crateUser(BasicUser basicUser){
        return basicUserRepository.save(basicUser);
    }

    public void deleteUser(Long id){
        basicUserRepository.deleteById(id);
    }


    public BasicUser updateProduct(Long id, BasicUser basicUser) {
        return basicUserRepository.findById(id)
                .map(product -> {
                    product.setFirst_name(basicUser.getFirst_name());
                    product.setLast_name(basicUser.getLast_name());
                    product.setEmail(basicUser.getBasicUserType());
                    product.setBasicUserType(basicUser.getBasicUserType());
                    product.setPassword(basicUser.getPassword());
                    product.setPhone(basicUser.getPhone());
                    return basicUserRepository.save(product);
                })
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
