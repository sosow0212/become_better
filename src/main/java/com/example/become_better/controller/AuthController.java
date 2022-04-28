package com.example.become_better.controller;

import com.example.become_better.model.User;
import com.example.become_better.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin
public class AuthController {

    private final AuthService authService;

    // 회원가입 Post
    @PostMapping("/auth/register")
    public ResponseEntity<?> registerProcess(@RequestBody User user) {
        return new ResponseEntity<>(authService.signup(user), HttpStatus.CREATED);
    }


}
