package com.ismaelboro.hotdealsmarket.repository;

import com.ismaelboro.hotdealsmarket.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
