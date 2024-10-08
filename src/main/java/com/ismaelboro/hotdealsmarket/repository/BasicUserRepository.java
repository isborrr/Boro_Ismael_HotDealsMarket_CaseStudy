package com.ismaelboro.hotdealsmarket.repository;

import com.ismaelboro.hotdealsmarket.model.BasicUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BasicUserRepository extends JpaRepository<BasicUser,Long> {

}
