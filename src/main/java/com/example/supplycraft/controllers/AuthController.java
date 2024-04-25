package com.example.supplycraft.controllers;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.supplycraft.services.UserService;
import com.example.supplycraft.dto.UserDTO;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

//    @PostMapping("/register")
//    public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO userDTO) {
//        userService.createUser(userDTO);
//        return ResponseEntity.ok("User registered successfully");
//    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody UserDTO userDTO) {
        String token = userService.loginUser(userDTO.getUsername(), userDTO.getPassword());
        return ResponseEntity.ok(token);
    }
}
