package com.example.become_better.service;

import com.example.become_better.model.BodyInfo;
import com.example.become_better.model.User;
import com.example.become_better.repository.BodyInfoRepository;
import com.example.become_better.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BodyInfoRepository bodyInfoRepository;

    @Transactional(readOnly = true)
    public User loadUserInfo(int id) {
        return userRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("User id를 찾을 수 없습니다.");
        });
    }

    @Transactional
    public BodyInfo writeUserBodyInfo(int id, BodyInfo bodyInfo) {
        User user = userRepository.findById(id).orElseThrow(()-> {
            return new IllegalArgumentException("User id를 찾을 수 없습니다.");
        });

        if(user.getBodyInfo() == null) {
            BodyInfo newBodyInfo = new BodyInfo();
            newBodyInfo.setBmi(bodyInfo.getBmi());
            newBodyInfo.setHeight(bodyInfo.getHeight());
            newBodyInfo.setWeight(bodyInfo.getWeight());
            newBodyInfo.setUser(user);
            bodyInfoRepository.save(newBodyInfo);
            user.setBodyInfo(newBodyInfo);
        } else {
            BodyInfo before = user.getBodyInfo();
            before.setHeight(bodyInfo.getHeight());
            before.setWeight(bodyInfo.getWeight());
            before.setBmi(bodyInfo.getBmi());
            before.setUser(user);
            user.setBodyInfo(before);
        }
        return bodyInfo;
    }

    @Transactional
    public String deleteUserById(int id) {
        userRepository.deleteById(id);
        return "삭제 완료";
    }
}
