package com.ismaelboro.hotdealsmarket.model;



import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
@Data
@Entity
@Table(name = "basic_users")
public class BasicUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @NotNull
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String  lastName;
    private String email;
    private String password ;
    @NotNull
    private String phone ;
    @Column(name = "basic_users_type")
    @Enumerated(EnumType.STRING)
    private Role role ;



//    private String  basicUserType ENUM('Customer', 'Admin') ;
}

