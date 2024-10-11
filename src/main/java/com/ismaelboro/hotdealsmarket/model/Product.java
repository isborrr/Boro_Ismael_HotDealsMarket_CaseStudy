package com.ismaelboro.hotdealsmarket.model;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.List;
//
//@Data
//@Entity
//@Table(name = "products")
//public class Product {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "product_id")
//    private Long id;
//    @Column(name = "product_name_and_size")
//    private String name;
//    private double buying_price;
//    private double selling_price;
//    private double market_price;
//    private double stock_quantity;
//    private double discount_rate;
//    private int discount_min_quantity;
//    private String product_image_path;
//    @ManyToOne// Change here to include cascade options
//    @JoinColumn(name = "product_category_id", referencedColumnName = "category_id", nullable = false)
//    private ProductCategory productCategory; // This establishes the foreign key relationship
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<CartItem> cartItems; // List of associated CartItem entities
//}


import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "product_name_and_size", nullable = false)
    private String productNameAndSize;

    @Column(name = "buying_price", nullable = false)
    private Double buyingPrice;

    @Column(name = "selling_price", nullable = false)
    private Double sellingPrice;

    @Column(name = "market_price", nullable = false)
    private Double marketPrice;

    @Column(name = "stock_quantity", nullable = false)
    private Integer stockQuantity;

    @ManyToOne
    @JoinColumn(name = "product_category_id", nullable = false)
    private ProductCategory productCategory;

    @Column(name = "discount_rate", nullable = false)
    private Double discountRate;

    @Column(name = "discount_min_quantity", nullable = false)
    private Integer discountMinQuantity;

    @Column(name = "product_image_path", nullable = false)
    private String productImagePath;
}
