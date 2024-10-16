package com.ismaelboro.hotdealsmarket.repository;

import com.ismaelboro.hotdealsmarket.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
