package com.ismaelboro.hotdealsmarket.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Controller;

@Data
@Entity
@Table(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long cartItemId;
    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private CustomerCart customerCart; // Reference to CustomerCart entity
//    @Column(name = "product_id", nullable = false)
//    private Long productId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "quantity", nullable = false)
    private  int quantity;

}
