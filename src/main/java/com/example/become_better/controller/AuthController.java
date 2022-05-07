package com.example.become_better.controller;

import com.example.become_better.dto.LoginRequestDto;
import com.example.become_better.dto.RegistRequestDto;
import com.example.become_better.model.User;
import com.example.become_better.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@RestController
@CrossOrigin
public class AuthController {

    private final AuthService authService;


    // 회원가입 Post
    @PostMapping("/register")
    public ResponseEntity<?> registerProcess(@RequestBody RegistRequestDto registRequestDto) {
        User user = new User();
        user.setUsername(registRequestDto.getUsername());
        user.setName(registRequestDto.getName());
        user.setEmail(registRequestDto.getEmail());
        user.setPassword(registRequestDto.getPassword());
        ResponseEntity<?> response = authService.signup(user);
        return response;
    }

    // 로그아웃
    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("로그아웃 처리");
    }

    @PostMapping("/login")
    public String login(LoginRequestDto loginRequestDto, HttpServletRequest request, HttpServletResponse response) {
        String token = response.getHeader("Authorization");
        return "good" + token;
    }

}


