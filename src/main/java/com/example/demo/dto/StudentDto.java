package com.example.demo.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentDto {
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
}
