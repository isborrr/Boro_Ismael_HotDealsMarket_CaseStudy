package com.ismaelboro.hotdealsmarket.repository;
import com.ismaelboro.hotdealsmarket.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    // Custom query to find all cart items associated with a customerId
    List<CartItem> findByCartCustomerId(Long customerId);
}
