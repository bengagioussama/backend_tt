package com.corner.app.controller;

import com.corner.app.entity.Users;
import com.corner.app.service.jwt.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class HelloController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/profile")
    public ResponseEntity<Users> getAllUsers(@AuthenticationPrincipal(expression = "username") String email){
        Users users = userService.getUserByEmail(email);
        System.out.println(users);
        return ResponseEntity.ok(users);
    }
}
