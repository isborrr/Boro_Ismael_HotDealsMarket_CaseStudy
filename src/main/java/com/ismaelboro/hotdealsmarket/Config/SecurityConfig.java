//package com.ismaelboro.hotdealsmarket.Config;
//////
//////public class SecurityConfig {
//////}
////
////import org.springframework.context.annotation.Bean;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.web.SecurityFilterChain;
////
////@EnableWebSecurity
////public class SecurityConfig {
////
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http
////                .csrf(csrf -> csrf.disable())  // Disable CSRF for all requests
////                .authorizeHttpRequests(auth -> auth
////                        .anyRequest().permitAll()  // Allow all requests without authentication
////                );
////        return http.build();
////    }
////}