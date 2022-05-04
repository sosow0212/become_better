package com.example.become_better.controller;

import com.example.become_better.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    // 모든 유저 정보 조회
    @GetMapping("/admin/members")
    public ResponseEntity<?> findAllMembers() {
        return new ResponseEntity<>(adminService.findAllMembers(), HttpStatus.OK);
    }

    // 유저들의 평균 신체 정보 조회
    @GetMapping("/admin/spec-avg")
    public ResponseEntity<?> findMemberSpecAvg() {
        return new ResponseEntity<>(adminService.findMemberSpecAvg(), HttpStatus.OK);
    }

}
