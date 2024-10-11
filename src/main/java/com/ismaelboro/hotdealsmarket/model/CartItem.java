package com.ismaelboro.hotdealsmarket.model;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import lombok.Data;
//import org.springframework.stereotype.Controller;
//
//import java.util.List;
//
//@Data
//@Entity
//@Table(name = "cart_items")
//public class CartItem {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "cart_item_id")
//    private Long cartItemId;
//    @ManyToOne
//    @JoinColumn(name = "cart_items_cart_id", referencedColumnName ="customer_cart_id", nullable = false)
//    private CustomerCart customerCart; // Reference to CustomerCart entity
////    @Column(name = "product_id", nullable = false)
////    private Long productId;
//
//    @ManyToOne
//    @JoinColumn(name = "cart_items_product_id", referencedColumnName ="product_id", nullable = false)
//    private Product product;
//    @Column(name = "quantity", nullable = false)
//    private  int quantity;
//
//
//
//    ///
//    @JsonIgnore
//    @OneToMany(mappedBy = "CartItem", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<CustomerCart> customerCarts; // List of associated CartItem entities
//
//}


import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

    @ManyToOne
    @JoinColumn(name = "cart_items_cart_id", nullable = false)
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "cart_items_product_id", nullable = false)
    private Product product;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;
}
