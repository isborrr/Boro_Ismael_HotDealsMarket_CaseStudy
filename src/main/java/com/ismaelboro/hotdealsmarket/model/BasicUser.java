package com.ismaelboro.hotdealsmarket.model;



import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import javax.management.relation.Role;
import java.security.PrivateKey;

@Data
@Entity
@Table(name = "basic_users")
public class BasicUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String  last_name;
    private String email;
    private String password ;
    @NotNull
    private String phone ;
    @Column(name = "basic_users_type")
    @Enumerated(EnumType.STRING)
    private BasicUserType basicUserType ;



//    private String  basicUserType ENUM('Customer', 'Admin') ;
}

