package com.ismaelboro.hotdealsmarket.controller;

import com.ismaelboro.hotdealsmarket.model.BasicUser;
import com.ismaelboro.hotdealsmarket.service.BasicUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class BasicUserController {
    @Autowired
    private BasicUserService basicUserService;

    @GetMapping
    public List<BasicUser>getAllUsers(){
        return basicUserService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BasicUser> getUserById(@PathVariable Long id) {
        Optional<BasicUser> user = basicUserService.getUserById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }





    @PostMapping
    public ResponseEntity<BasicUser> createUser(@RequestBody BasicUser user){
        BasicUser createUser = basicUserService.crateUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BasicUser> updateUser(@PathVariable Long id, @RequestBody BasicUser udatedUser){
        BasicUser user = basicUserService.updateUser(id,udatedUser);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        basicUserService.deleteUser(id);
        return  new ResponseEntity<>("User has been deleted",HttpStatus.OK);
    }
}
