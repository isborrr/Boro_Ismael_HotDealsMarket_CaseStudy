package com.ismaelboro.hotdealsmarket.model;

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
