package com.example.become_better.controller;

import com.example.become_better.config.auth.PrincipalDetails;
import com.example.become_better.model.BodyInfo;
import com.example.become_better.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/user/info/body")
    public ResponseEntity<?> writeUserBodyInfo(@RequestBody BodyInfo bodyInfo, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        int id = principalDetails.getUser().getId();
        return new ResponseEntity<>(userService.writeUserBodyInfo(id, bodyInfo), HttpStatus.OK);
    }
}
