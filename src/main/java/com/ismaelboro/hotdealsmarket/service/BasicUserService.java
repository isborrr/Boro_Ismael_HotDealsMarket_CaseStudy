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
//    @Autowired
//    private UserDetailsServiceAutoConfiguration userDetailsServiceAutoConfiguration;

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


    public BasicUser updateUser(Long id, BasicUser updatedBasicUser) {
        return basicUserRepository.findById(id)
                .map(basicUser -> {
                    basicUser.setFirst_name(updatedBasicUser.getFirst_name());
                    basicUser.setLast_name(updatedBasicUser.getLast_name());
                    basicUser.setEmail(updatedBasicUser.getEmail());
                    basicUser.setBasicUserType(updatedBasicUser.getBasicUserType());
                    basicUser.setPassword(updatedBasicUser.getPassword());
                    basicUser.setPhone(updatedBasicUser.getPhone());
                    return basicUserRepository.save(basicUser);
                })
                .orElseThrow(() -> new RuntimeException("user not found"));
    }
}
