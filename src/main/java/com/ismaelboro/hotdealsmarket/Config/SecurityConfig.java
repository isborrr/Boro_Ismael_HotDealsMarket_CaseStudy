package com.ismaelboro.hotdealsmarket.Config;
import com.ismaelboro.hotdealsmarket.service.CustomUserDetails;
import com.ismaelboro.hotdealsmarket.service.CustomUserDetailsService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService userDetailsService;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/css/**", "/js/**", "/images/**", "/sign-in","/sign-up", "/products").permitAll()  // Public access
                        .requestMatchers("/user/**","/add-to-cart","/buy-now","/complete-order").hasRole("CUSTOMER")  // Employee task hub
                        .requestMatchers("/admin/**","/admin").hasRole("ADMIN")  // Admin access for managing employees and uploading tasks
//                        .requestMatchers("/tasks/**").hasRole("ADMIN")  // Admin-only access for managing tasks
                        .anyRequest().permitAll())  // All other requests require authentication

                .formLogin(formLogin -> formLogin
                        .loginPage("/sign-in")
                        .permitAll()
                        .successHandler((request, response, authentication) -> {
                            authentication.getAuthorities().forEach(grantedAuthority -> {
                                String role = grantedAuthority.getAuthority();
                                try {
                                    if (role.equals("ROLE_ADMIN")) {
                                        response.sendRedirect("/admin");  // Admin redirect
                                    } else if (role.equals("ROLE_CUSTOMER")) {
                                        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
                                        Long id = userDetails.getId();  // Getting the ID from the authenticated user
                                        response.sendRedirect("/user/"+id);  // Employee redirect
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            });
                        }))
                .logout(logout -> logout.logoutSuccessUrl("/sign-in").permitAll())
                .userDetailsService(userDetailsService)
                .exceptionHandling(exceptions -> exceptions
                        .accessDeniedHandler(new AccessDeniedHandler() {
                            @Override
                            public void handle(HttpServletRequest request, HttpServletResponse response,
                                               org.springframework.security.access.AccessDeniedException accessDeniedException) throws IOException {
                                response.sendRedirect("/sign-in");
                            }
                        })
                );



        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}





























//package com.ismaelboro.hotdealsmarket.Config;


//
//import com.ismaelboro.hotdealsmarket.service.BasicUserService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    private final BasicUserService basicUserService;
//
//    public SecurityConfig(BasicUserService basicUserService) {
//        this.basicUserService = basicUserService;
//    }
//
//
////    @Bean
////    public BCryptPasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
//
//
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf((csrf) -> csrf.disable())  // Disable CSRF for development purposes (enable in production)
//                .authorizeHttpRequests((authz) -> authz
//                        .requestMatchers("/admin/**").hasAuthority("Admin")
//                        .requestMatchers("/user/**").hasAuthority("Customer")
//                        .requestMatchers("/sign-up", "/sign-in", "/products", "/css/**", "/js/**").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin((form) -> form
//                        .loginPage("/sign-in")
//                        .defaultSuccessUrl("/products", true)
//                        .permitAll()
//                )
//                .logout((logout) -> logout
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/sign-in")
//                        .permitAll());
//
//        return http.build();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
//        return authConfig.getAuthenticationManager();
//    }
//}
