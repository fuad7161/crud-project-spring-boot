package com.example.demo.exception;

public class UserDoseNotExistException extends RuntimeException{
    public UserDoseNotExistException(String message) {
        super(message);
    }
}
