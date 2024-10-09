package com.ismaelboro.hotdealsmarket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @Column(name = "product_name_and_size")
    private String name;
    private double buying_price;
    private double selling_price;
    private double market_price;
    private double stock_quantity;
    private double discount_rate;
    private int discount_min_quantity;
    private String product_image_path;
    @ManyToOne// Change here to include cascade options
    @JoinColumn(name = "product_category_id", referencedColumnName = "category_id", nullable = false)
    private ProductCategory productCategory; // This establishes the foreign key relationship

    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems; // List of associated CartItem entities
}
