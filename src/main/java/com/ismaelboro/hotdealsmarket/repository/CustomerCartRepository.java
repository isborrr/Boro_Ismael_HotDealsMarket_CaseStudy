package com.ismaelboro.hotdealsmarket.repository;

import com.ismaelboro.hotdealsmarket.model.CustomerCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerCartRepository extends JpaRepository<CustomerCart, Long> {
}
