package com.ismaelboro.hotdealsmarket.repository;

import com.ismaelboro.hotdealsmarket.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    // Custom query to find all cart items associated with a customerId
    List<CartItem> findByCartCustomerId(Long customerId);
}
