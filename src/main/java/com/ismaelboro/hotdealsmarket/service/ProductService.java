package com.ismaelboro.hotdealsmarket.service;

import com.ismaelboro.hotdealsmarket.model.Product;
import com.ismaelboro.hotdealsmarket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
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
                    product.setProductNameAndSize(updatedProduct.getProductNameAndSize());
                    product.setBuyingPrice(updatedProduct.getBuyingPrice());
                    product.setSellingPrice(updatedProduct.getSellingPrice());
                    product.setMarketPrice(updatedProduct.getMarketPrice());
                    product.setStockQuantity(updatedProduct.getStockQuantity());
                    product.setProductCategory(updatedProduct.getProductCategory());
                    product.setDiscountRate(updatedProduct.getDiscountRate());
                    product.setDiscountMinQuantity(updatedProduct.getDiscountMinQuantity());
                    product.setProductImagePath(updatedProduct.getProductImagePath());
                    return productRepository.save(product);
                })
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product updateProductQuantity(String productName, int productQuantity){
        Product returnProduct = null;
         List<Product> products = getAllProducts();
         for(Product product : products){
             if(Objects.equals(productName, product.getProductNameAndSize())){
                 returnProduct = product;
             }
         }
          if(returnProduct != null){
              returnProduct.setStockQuantity(returnProduct.getStockQuantity() + productQuantity);
              productRepository.save(returnProduct);
          }
        return returnProduct;
    }


    public List<Product> getProductsByCategory(Long categoryId) {
        return productRepository.findByProductCategoryCategoryId(categoryId);
    }
}
