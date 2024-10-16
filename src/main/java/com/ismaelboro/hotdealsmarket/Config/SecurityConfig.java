package com.ismaelboro.hotdealsmarket.Config;

import com.ismaelboro.hotdealsmarket.service.BasicUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final BasicUserService basicUserService;

    public SecurityConfig(BasicUserService basicUserService) {
        this.basicUserService = basicUserService;
    }


//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf((csrf) -> csrf.disable())  // Disable CSRF for development purposes (enable in production)
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/admin/**").hasAuthority("Admin")
                        .requestMatchers("/user/**").hasAuthority("Customer")
                        .requestMatchers("/sign-up", "/sign-in", "/products", "/css/**", "/js/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/sign-in")
                        .defaultSuccessUrl("/products", true)
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/sign-in")
                        .permitAll());

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}
