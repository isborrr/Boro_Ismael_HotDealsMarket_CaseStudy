package com.ismaelboro.hotdealsmarket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "product_categories")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;
    private String category_name;
    @JsonIgnore
    @OneToMany(mappedBy = "productCategory", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
    private List<Product> products; // This creates a bidirectional relationship


    // Optional: Method to update product references when category changes
//    public void updateProductsCategory(ProductCategory newCategory) {
//        for (Product product : products) {
//            product.setProductCategory(newCategory);
//        }
//    }

}
