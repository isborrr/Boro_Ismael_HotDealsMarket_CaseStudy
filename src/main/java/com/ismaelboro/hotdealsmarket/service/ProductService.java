package com.ismaelboro.hotdealsmarket.service;

import com.ismaelboro.hotdealsmarket.model.Product;
import com.ismaelboro.hotdealsmarket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product>  getProductById(Long id){
        return productRepository.findById(id);
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public Product updateProduct(Long id, Product updatedProduct){
        return productRepository.findById(id)
                .map(product -> {
                    product.setName(updatedProduct.getName());
                    product.setBuying_price(updatedProduct.getBuying_price());
                    product.setSelling_price(updatedProduct.getSelling_price());
                    product.setMarket_price(updatedProduct.getMarket_price());
                    product.setStock_quantity(updatedProduct.getStock_quantity());
                    product.setProductCategory(updatedProduct.getProductCategory());
                    product.setDiscount_rate(updatedProduct.getDiscount_rate());
                    product.setDiscount_min_quantity(updatedProduct.getDiscount_min_quantity());
                    product.setProduct_image_path(updatedProduct.getProduct_image_path());
                    return productRepository.save(product);
                })
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }


}
