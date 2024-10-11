package com.ismaelboro.hotdealsmarket.service;

import com.ismaelboro.hotdealsmarket.model.ProductCategory;
import com.ismaelboro.hotdealsmarket.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public List<ProductCategory> getAllProductCategories(){
        return productCategoryRepository.findAll();
    }

    public Optional<ProductCategory> getProductCategoryById(Long id){
        return productCategoryRepository.findById(id);
    }

    public ProductCategory createProductCategory(ProductCategory productCategory){
        return productCategoryRepository.save(productCategory);

    }

    public void deleteProductCategory(Long id){
        productCategoryRepository.deleteById(id);
    }

    public ProductCategory updateProductCategory(Long id, ProductCategory updatedProductCategory){
            return productCategoryRepository.findById(id)
                    .map(productCategory -> {
                        productCategory.setCategoryName(updatedProductCategory.getCategoryName());
                        return productCategoryRepository.save(productCategory);
                    })
                    .orElseThrow(() -> new RuntimeException("Product category not found"));
        }

}
