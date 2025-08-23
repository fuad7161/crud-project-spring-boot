package com.example.demo.controller;

import com.example.demo.dto.AuthUserDto;
import com.example.demo.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "api/v1/auth")
public class AuthController {

    @Autowired
    private final AuthUserService authUserService;
    public AuthController(AuthUserService authUserService) {
        this.authUserService = authUserService;
    }

    @PostMapping(value = "/registration")
    public ResponseEntity<String> registration(@RequestBody AuthUserDto dto) {
        System.out.println("This is registration page");
        authUserService.registerUser(dto);
        return ResponseEntity.ok("User registered successfully!");
    }
}
