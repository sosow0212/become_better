package com.example.become_better.controller;

import com.example.become_better.config.auth.PrincipalDetails;
import com.example.become_better.model.BodyInfo;
import com.example.become_better.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin
public class UserController {

    private final UserService userService;

    // 유저 정보 읽기
    @GetMapping("/user/info")
    public ResponseEntity<?> loadUserInfo(Authentication authentication) {
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        int id = principal.getUser().getId();
        return new ResponseEntity<>(userService.loadUserInfo(id), HttpStatus.OK);
    }

    // 유저 신체 정보 저장
    @PostMapping("/user/info/body")
    public ResponseEntity<?> writeUserBodyInfo(Authentication authentication, @RequestBody BodyInfo bodyInfo) {
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        int id = principal.getUser().getId();
        return new ResponseEntity<>(userService.writeUserBodyInfo(id, bodyInfo), HttpStatus.OK);
    }

    // 유저 회원 삭제
    @DeleteMapping("/user/delete")
    public ResponseEntity<?> deleteUser(Authentication authentication) {
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        int id = principal.getUser().getId();
        String msg = userService.deleteUserById(id);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }


}
