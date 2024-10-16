package com.ismaelboro.hotdealsmarket.repository;

import com.ismaelboro.hotdealsmarket.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCartRepository extends JpaRepository<Cart, Long> {
}
