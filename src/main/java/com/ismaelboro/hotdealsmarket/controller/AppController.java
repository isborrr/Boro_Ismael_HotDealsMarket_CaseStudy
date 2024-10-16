package com.ismaelboro.hotdealsmarket.controller;

import com.ismaelboro.hotdealsmarket.model.*;
import com.ismaelboro.hotdealsmarket.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    @Autowired
    private CartService cartService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Handles GET requests for the sign-in page
    @GetMapping("/sign-in")
    public String signInPage() {
        return "sign-in"; // Name of your Thymeleaf template for the sign-in page
    }

    // Handles GET requests for the sign-up page
    @GetMapping("/sign-up")
    public String signUpPage(Model model) {
        model.addAttribute("basicUser", new BasicUser());
        return "sign-up"; // Name of your Thymeleaf template for the sign-in page
    }

    @PostMapping("/sign-up")
    public String signup(BasicUser basicUser) {
// Encode the password before saving
        String encodedPassword = passwordEncoder.encode(basicUser.getPassword());
        basicUser.setPassword(encodedPassword); // Set the encoded password

        // Save the user
        basicUser.setRole(Role.ADMIN);
        basicUserService.crateUser(basicUser);
        return "redirect:/sign-in"; // Redirect to login page after signup
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
    public String user(@PathVariable Long id, @RequestParam(required = false) Long categoryId, Model model) {
        List<Product> products = categoryId != null
                ? productService.getProductsByCategory(categoryId)
                : productService.getAllProducts();

        List<ProductCategory> productCategories = productCategoryService.getAllProductCategories();

        model.addAttribute("products", products);
        model.addAttribute("productCategories", productCategories);
        model.addAttribute("selectedCategory", categoryId);

        Optional<BasicUser> customer = basicUserService.getUserById(id);
        if (customer.isPresent()) {
            model.addAttribute("customer", customer.get());
        } else {
            return "error"; // Handle user not found
        }

        return "user"; // Name of your Thymeleaf template
    }




    // Method to handle the request for cart items by customerId
    @GetMapping("/user/{id}/cart-items")
    public String getCartItemsByCustomerId(@PathVariable Long id, Model model) {
        List<CartItem> cartItems = cartItemService.getCartItemsByCustomerId(id);
        Optional<BasicUser> customer = basicUserService.getUserById(id);
        customer.ifPresent(basicUser -> model.addAttribute("customer", basicUser));
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("customerId", id);
        return "cart-items"; // Thymeleaf template name
    }

//
    // delete commented code bellow

//    @PostMapping("/sign-up")
//    public String signup(BasicUser basicUser) {
//        // Save the user
//        basicUser.setBasicUserType(BasicUserType.Customer);
//        basicUserService.crateUser(basicUser);
//        return "redirect:/sign-in"; // Redirect to login page after signup
//    }

//    post add cart buy now

    //add To Cat
//@PostMapping("/user/{id}/cart-items")
//public void addToCart(@RequestParam Long customerId, @RequestParam Long productId, @RequestParam int quantity) {
////        quantity = 1;
//    cartService.addToCart(customerId, productId, quantity, ReceivingStatus.Processed);
//}
//
//    //Buy now
//    @PostMapping("/buy-now")
//    public void buyNow(@RequestParam Long customerId, @RequestParam Long productId, @RequestParam int quantity) {
//        cartService.addToCart(customerId, productId, quantity, ReceivingStatus.Shipped);
//    }


    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam("productId") Long productId, @RequestParam("customerId") Long customerId, Model model) {
        cartService.addToCart(customerId, productId, ReceivingStatus.Processed);
        return "redirect:/user/" + customerId + "/cart-items";
    }

    @PostMapping("/buy-now")
    public String buyNow(@RequestParam("productId") Long productId, @RequestParam("customerId") Long customerId, Model model) {
        cartService.addToCart(customerId, productId, ReceivingStatus.Shipped);
        return "redirect:/user/" + customerId + "/cart-items";
    }


    @PostMapping("/complete-order")
    public String completeOrder(@RequestParam("productId") Long productId, @RequestParam("customerId") Long customerId, Model model) {
        cartService.addToCart(customerId, productId, ReceivingStatus.Shipped);
        return "redirect:/user/" + customerId + "/cart-items";
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
