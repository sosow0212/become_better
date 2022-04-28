package com.example.become_better.service;

import com.example.become_better.model.User;
import com.example.become_better.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User loadUserInfo(int id) {
        return userRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("User id를 찾을 수 없습니다.");
        });
    }
}
