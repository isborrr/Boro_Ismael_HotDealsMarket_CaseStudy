package com.ismaelboro.hotdealsmarket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "customer_cart")
public class CustomerCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long cartId;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Enumerated(EnumType.STRING)
    @Column(name = "receiving_status", nullable = false)
    private ReceivingStatus receivingStatus;

    @JsonIgnore
    @OneToMany(mappedBy = "customerCart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems; // List of associated CartItem entities
}