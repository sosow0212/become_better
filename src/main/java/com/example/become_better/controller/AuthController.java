package com.example.become_better.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @GetMapping("/")
    public String hi() {
        return "hello : world";
    }
}
