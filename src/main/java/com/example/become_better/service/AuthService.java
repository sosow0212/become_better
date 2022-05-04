package com.example.become_better.service;


import com.example.become_better.model.User;
import com.example.become_better.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional // Write(Insert, Update, Delete)
    public ResponseEntity<?> signup(User user) {
        if(userRepository.findByUsername(user.getUsername()) == null) {
            String rawPassword = user.getPassword();
            String encPassword = bCryptPasswordEncoder.encode(rawPassword);
            user.setPassword(encPassword);
            user.setRole("ROLE_USER");
            return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("중복된 유저입니다.", HttpStatus.BAD_REQUEST);
        }
    }
}
