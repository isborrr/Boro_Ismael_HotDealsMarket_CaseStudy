package com.ismaelboro.hotdealsmarket.repository;

import com.ismaelboro.hotdealsmarket.model.BasicUser;
import com.ismaelboro.hotdealsmarket.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface BasicUserRepository extends JpaRepository<BasicUser,Long> {
    List<BasicUser> findByRole(Role role);

    Optional<BasicUser> findByEmail(String email);
}
