package com.ismaelboro.hotdealsmarket.service;


import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@Getter
public class CustomUserDetails implements UserDetails {
    private String email;
    private String password;
    private Long id;
//    private String name; // Additional field for the user's name
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(String email, String password, Long id, Collection<? extends GrantedAuthority> authorities) {
        this.email = email;
        this.password = password;
        this.id = id;
        this.authorities = authorities;
    }

    @Override
    public String getUsername() {
        return "";
    }
}
