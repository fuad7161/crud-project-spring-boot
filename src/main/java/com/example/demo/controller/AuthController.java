package com.example.demo.controller;

import com.example.demo.dto.AuthUserDto;
import com.example.demo.exception.UserAlreadyExistException;
import com.example.demo.exception.UserDoseNotExistException;
import com.example.demo.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/auth")
public class AuthController {

    @Autowired
    private final AuthUserService authUserService;
    public AuthController(AuthUserService authUserService) {
        this.authUserService = authUserService;
    }

    @PostMapping(value = "/registration")
    public ResponseEntity<String> registration(@RequestBody AuthUserDto dto) throws UserAlreadyExistException{
        try{
            authUserService.registerUser(dto);
        }catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Registration Successful");
    }

    @DeleteMapping(value = "/delete-user/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable String email) throws UserDoseNotExistException {
        try{
            authUserService.removeUser(email);
        }catch (UserDoseNotExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Delete Successful");
    }
}
