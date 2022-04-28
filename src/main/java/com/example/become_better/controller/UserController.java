package com.example.become_better.controller;

import com.example.become_better.config.auth.PrincipalDetails;
import com.example.become_better.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@CrossOrigin
public class UserController {

    private final UserService userService;

    @GetMapping("/user/info")
    public ResponseEntity<?> loadUserInfo(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        int id = principalDetails.getUser().getId();
        return new ResponseEntity<>(userService.loadUserInfo(id), HttpStatus.OK);
    }
}
