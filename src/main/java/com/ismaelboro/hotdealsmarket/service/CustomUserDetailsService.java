package com.ismaelboro.hotdealsmarket.service;

import com.ismaelboro.hotdealsmarket.model.BasicUser;
import com.ismaelboro.hotdealsmarket.repository.BasicUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    private BasicUserRepository basicUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Fetch the user from the repository
        Optional <BasicUser>   basicUser = basicUserRepository.findByEmail(email);
        if (basicUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        // Manually prefix the role with 'ROLE_' if it's not already prefixed
        String role = basicUser.get().getRole().toString();
        String roleWithPrefix = "ROLE_"+role;
        // Return the user details with prefixed role
        return new CustomUserDetails(basicUser.get().getEmail(),  basicUser.get().getPassword(),basicUser.get().getId(),
                Collections.singletonList(new SimpleGrantedAuthority(roleWithPrefix)));
    }
}
