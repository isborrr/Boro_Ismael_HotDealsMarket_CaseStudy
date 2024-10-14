package com.ismaelboro.hotdealsmarket.controller;

import com.ismaelboro.hotdealsmarket.model.BasicUser;
import com.ismaelboro.hotdealsmarket.model.CartItem;
import com.ismaelboro.hotdealsmarket.model.Product;
import com.ismaelboro.hotdealsmarket.model.ProductCategory;
import com.ismaelboro.hotdealsmarket.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class AppController {

    @Autowired
    private ProductService productService;

    @Autowired
    private BasicUserService basicUserService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private CartItemService cartItemService;

    // Handles GET requests for the sign-in page
    @GetMapping("/sign-in")
    public String signInPage() {
        return "sign-in"; // Name of your Thymeleaf template for the sign-in page
    }

    // Handles GET requests for the sign-up page
    @GetMapping("/sign-up")
    public String signUpPage() {
        return "sign-up"; // Name of your Thymeleaf template for the sign-in page
    }

    @GetMapping("/products")
    public String getAllProducts (@RequestParam(required = false) Long categoryId, Model model) {
        List<Product> products;
        if (categoryId != null) {
            products = productService.getProductsByCategory(categoryId);
        } else {
            products = productService.getAllProducts();
        }
        List<ProductCategory> productCategories = productCategoryService.getAllProductCategories();

        model.addAttribute("products", products);
        model.addAttribute("productCategories", productCategories);
        model.addAttribute("selectedCategory", categoryId);
        return "products";
    }

    @GetMapping("/admin")
    public String adminPage( Model model) {
        List<Product> products = productService.getAllProducts();
        List<BasicUser> customerUsers = basicUserService.getOnlyCustomers();
        model.addAttribute("products", products);
        model.addAttribute("customerUsers", customerUsers);

        return "admin"; // Name of your Thymeleaf template for the sign-in page
    }

    @GetMapping("/user/{id}")
    public String user(@PathVariable Long id, Model model) {
        Optional<BasicUser> customer = basicUserService.getUserById(id);
        if (customer.isPresent()) {
            model.addAttribute("customer", customer.get());
        } else {
            // Handle the case where the user is not found (e.g., redirect or return an error view)
            return "error"; // or whatever error handling you want to do
        }
        return "user"; // Name of your Thymeleaf template
    }



    // Method to handle the request for cart items by customerId
    @GetMapping("/customer/{customerId}/cart-items")
    public String getCartItemsByCustomerId(@PathVariable Long customerId, Model model) {
        List<CartItem> cartItems = cartItemService.getCartItemsByCustomerId(customerId);
        Optional<BasicUser> customer = basicUserService.getUserById(customerId);
        customer.ifPresent(basicUser -> model.addAttribute("customer", basicUser));
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("customerId", customerId);
        return "cart-items"; // Thymeleaf template name
    }

//    @GetMapping("/user/cart-items/{id}")
//    public String getCartItemsByCustomerId(@PathVariable Long customerId, Model model) {
//        List<CartItem> cartItems = cartItemService.getCartItemsByCustomerId(customerId);
//        model.addAttribute("cartItems", cartItems);
//        model.addAttribute("customerId", customerId);
//
//        return "cart-items"; // Name of my  Thymeleaf template
//    }

}
