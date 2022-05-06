package com.example.become_better.dto;

import lombok.Data;
@Data
public class RegistRequestDto {
    private String username;
    private String password;
    private String name;
    private String email;
}