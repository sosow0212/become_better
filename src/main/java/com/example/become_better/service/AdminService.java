package com.example.become_better.service;

import com.example.become_better.model.BodyInfo;
import com.example.become_better.model.User;
import com.example.become_better.repository.BodyInfoRepository;
import com.example.become_better.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final UserRepository userRepository;
    private final BodyInfoRepository bodyInfoRepository;

    @Transactional
    public List<User> findAllMembers() {
        return userRepository.findAll();
    }

    @Transactional
    public Object findMemberSpecAvg() {
        if (bodyInfoRepository.findAll() == null) {
            return "자료가 없습니다.";
        } else {
            List<BodyInfo> bodyInfoList = bodyInfoRepository.findAll();
            double heightAvg = 0, weightAvg = 0, bmiAvg = 0;
            int count = 0;
            for (BodyInfo bodyInfo : bodyInfoList) {
                heightAvg += bodyInfo.getHeight();
                weightAvg += bodyInfo.getWeight();
                bmiAvg += bodyInfo.getBmi();
                count++;
            }
            heightAvg /= count;
            weightAvg /= count;
            bmiAvg /= count;

            Map<String, Double> map = new HashMap<>();
            map.put("heightAvg", heightAvg);
            map.put("weightAvg", weightAvg);
            map.put("bmiAvg", bmiAvg);

            return map;
        }

    }
}
