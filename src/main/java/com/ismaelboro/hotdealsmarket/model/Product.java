package com.ismaelboro.hotdealsmarket.model;

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
