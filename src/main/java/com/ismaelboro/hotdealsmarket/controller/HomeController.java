//package com.ismaelboro.hotdealsmarket.controller;
//
//import com.ismaelboro.hotdealsmarket.model.Product;
//import com.ismaelboro.hotdealsmarket.model.ProductCategory;
//import com.ismaelboro.hotdealsmarket.service.ProductCategoryService;
//import com.ismaelboro.hotdealsmarket.service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
//@Controller
//@RequestMapping ("/products")
//public class HomeController {
//
//    @Autowired
//    private ProductService productService;
//
//    @Autowired
//    private ProductCategoryService  productCategoryService;
////    @GetMapping("/products")
//    @GetMapping
//    public String getAllProducts (@RequestParam(required = false) Long categoryId, Model model) {
//        List<Product> products;
//        if (categoryId != null) {
//            products = productService.getProductsByCategory(categoryId);
//        } else {
//            products = productService.getAllProducts();
//        }
//        List<ProductCategory> productCategories = productCategoryService.getAllProductCategories();
//
//        model.addAttribute("products", products);
//        model.addAttribute("productCategories", productCategories);
//        model.addAttribute("selectedCategory", categoryId);
//        return "products";
//    }
//}
