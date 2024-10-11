package com.ismaelboro.hotdealsmarket.model;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.List;
//
//@Data
//@Entity
//@Table(name = "customer_cart")
//public class CustomerCart {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "customer_cart_id")
//    private Long customerCartId;
//
//    @Column(name = "customer_id", nullable = false)
//    private Long customerId;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "receiving_status", nullable = false)
//    private ReceivingStatus receivingStatus;
//
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "customerCart", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<CartItem> cartItems; // List of associated CartItem entities
//
//
//
//    ///////
//
//    @ManyToOne
//    @JoinColumn(name = "customer_cart_id", referencedColumnName ="cart_items_cart_id", nullable = false)
//    private CartItem cartItem;
//}

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Enumerated(EnumType.STRING)
    @Column(name = "receiving_status", nullable = false)
    private ReceivingStatus receivingStatus;

    @JsonIgnore
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems;
}
