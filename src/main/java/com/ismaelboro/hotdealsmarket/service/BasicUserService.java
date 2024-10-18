package com.ismaelboro.hotdealsmarket.service;
import org.springframework.security.core.GrantedAuthority;

import com.ismaelboro.hotdealsmarket.model.BasicUser;
import com.ismaelboro.hotdealsmarket.model.Role;
import com.ismaelboro.hotdealsmarket.repository.BasicUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class BasicUserService  {

    @Autowired
    private BasicUserRepository basicUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Inject PasswordEncoder instead of BCryptPasswordEncoder

    public BasicUser crateUser(BasicUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encode the password
        basicUserRepository.save(user);
        return user;
    }

    public List<BasicUser> getAllUsers(){
        return basicUserRepository.findAll();
    }

    public Optional<BasicUser> getUserById(Long id){
        return basicUserRepository.findById(id);
    }

    public void deleteUser(Long id){
        basicUserRepository.deleteById(id);
    }

    public List<BasicUser> getOnlyCustomers() {
        return basicUserRepository.findByRole(Role.CUSTOMER);
    }

//    public int countTotalCustomer() {
//        List<BasicUser> basicUsersList = basicUserRepository.findByRole(Role.CUSTOMER);
//        return  basicUsersList.size();
//    }

    public BasicUser updateUser(Long id, BasicUser updatedBasicUser) {
        return basicUserRepository.findById(id)
                .map(basicUser -> {
                    basicUser.setFirstName(updatedBasicUser.getFirstName());
                    basicUser.setLastName(updatedBasicUser.getLastName());
                    basicUser.setEmail(updatedBasicUser.getEmail());
                    basicUser.setRole(updatedBasicUser.getRole());
                    basicUser.setPassword(updatedBasicUser.getPassword());
                    basicUser.setPhone(updatedBasicUser.getPhone());
                    return basicUserRepository.save(basicUser);
                })
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
























//
//@Service
//public class BasicUserService implements UserDetailsService {
//    @Autowired
//    private BasicUserRepository basicUserRepository;
//
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        BasicUser user = (BasicUser) basicUserRepository.findByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//
//        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + user.getBasicUserType().name()); // ROLE_Admin or ROLE_Customer
//
//        return org.springframework.security.core.userdetails.User
//                .withUsername(user.getEmail())
//                .password(user.getPassword())
//                .authorities(Collections.singletonList(authority)) // Add the authority based on user type
//                .build();
//    }
//
//    public BasicUser crateUser(BasicUser user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encode the password
//        basicUserRepository.save(user);
//        return user;
//    }
//
//
//
////    @Autowired
////    private UserDetailsServiceAutoConfiguration userDetailsServiceAutoConfiguration;
//
//    public List<BasicUser> getAllUsers(){
//        return basicUserRepository.findAll();
//    }
//
//    public Optional<BasicUser> getUserById(Long id){
//        return basicUserRepository.findById(id);
//    }
//
////    public BasicUser crateUser(BasicUser basicUser){
////
////
////        return basicUserRepository.save(basicUser);
////    }
//
//    public void deleteUser(Long id){
//        basicUserRepository.deleteById(id);
//    }
//
//    public List<BasicUser> getOnlyCustomers() {
//        return basicUserRepository.findByBasicUserType(BasicUserType.Customer);
//    }
//
//    public BasicUser updateUser(Long id, BasicUser updatedBasicUser) {
//        return basicUserRepository.findById(id)
//                .map(basicUser -> {
//                    basicUser.setFirstName(updatedBasicUser.getFirstName());
//                    basicUser.setLastName(updatedBasicUser.getLastName());
//                    basicUser.setEmail(updatedBasicUser.getEmail());
//                    basicUser.setBasicUserType(updatedBasicUser.getBasicUserType());
//                    basicUser.setPassword(updatedBasicUser.getPassword());
//                    basicUser.setPhone(updatedBasicUser.getPhone());
//                    return basicUserRepository.save(basicUser);
//                })
//                .orElseThrow(() -> new RuntimeException("user not found"));
//    }
//
//
//}
