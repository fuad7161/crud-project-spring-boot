package com.example.demo.dto;

import com.example.demo.entity.AuthUser;
import lombok.Data;

@Data
public class AuthUserDto {
    public AuthUserDto(AuthUser authUser) {
        this.email = authUser.getEmail();
        this.password = authUser.getPassword();
    }
    private String email;
    private String password;
}
