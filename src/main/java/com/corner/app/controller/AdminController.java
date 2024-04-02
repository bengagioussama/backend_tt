package com.corner.app.controller;

import com.corner.app.entity.Users;
import com.corner.app.service.jwt.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserServiceImpl userService;


    @GetMapping("/users")
    public ResponseEntity<List<Users>> getAllUsers(){
        List<Users> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        System.out.println("deleting"+userId);
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }


}