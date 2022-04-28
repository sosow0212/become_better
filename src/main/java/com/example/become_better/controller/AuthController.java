package com.example.become_better.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthController {
    @GetMapping("/register")
    public String hi() {
        return "hello : world";
    }


}
