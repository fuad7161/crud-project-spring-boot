package com.example.demo.service;

import com.example.demo.dto.AuthUserDto;
import com.example.demo.entity.AuthUser;
import com.example.demo.exception.UserAlreadyExistException;
import com.example.demo.exception.UserDoseNotExistException;
import com.example.demo.repository.AuthUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthUserService {
    @Autowired
    private final AuthUserRepository authUserRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthUserService(AuthUserRepository authUserRepository, PasswordEncoder passwordEncoder) {
        this.authUserRepository = authUserRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public List<AuthUserDto> getAllUsers() {
//        return authUserRepository.getAuthUsers();

        return authUserRepository.findAll()
                .stream()
                .map(AuthUserDto::new)
                .collect(Collectors.toList());
    }

    public void registerUser(AuthUserDto dto) {
        if (authUserRepository.existsByEmail(dto.getEmail())) {
            throw new UserAlreadyExistException("Email Already Exists");
        }

        AuthUser authUser = new AuthUser();
        authUser.setEmail(dto.getEmail());
        authUser.setPassword(passwordEncoder.encode(dto.getPassword()));
        authUserRepository.save(authUser);
    }

    @Transactional
    public void removeUser(String email) {
        if (authUserRepository.existsByEmail(email)) {
            authUserRepository.deleteAuthUserByEmail(email);
        }else{
            throw new UserDoseNotExistException("User dose Not Exists");
        }
    }
}
