package com.ismaelboro.hotdealsmarket.controller;


import com.ismaelboro.hotdealsmarket.model.ProductCategory;
import com.ismaelboro.hotdealsmarket.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productcategory")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;
    @GetMapping
    public List<ProductCategory> getAllProductCategories() {
        return productCategoryService.getAllProductCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCategory> getProductCategoryById(@PathVariable Long id) {
        Optional<ProductCategory> productCategory = productCategoryService.getProductCategoryById(id);
        return productCategory.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<ProductCategory> createProductCategory(@RequestBody ProductCategory productCategory) {
        ProductCategory createdProductCategory = productCategoryService.createProductCategory(productCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProductCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductCategory> updateProductCategory(@PathVariable Long id, @RequestBody ProductCategory updatedProductCategory) {
        ProductCategory productCategory = productCategoryService.updateProductCategory(id, updatedProductCategory);
        return ResponseEntity.ok(productCategory);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductCategory(@PathVariable Long id) {
        productCategoryService.deleteProductCategory(id);
        return new ResponseEntity<>("ProductCategory has been deleted ",HttpStatus.OK);
    }
}
