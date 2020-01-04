package com.fourman.anamdobby.service;

import com.fourman.anamdobby.model.User;
import com.fourman.anamdobby.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException(userId + " ID인 User를 찾을 수 없습니다."));
    }

    public User findUserByNaverId(String naverId) {
        return userRepository.findUserByNaverId(naverId)
                .orElseThrow(() -> new RuntimeException(naverId + " ID인 User를 찾을 수 없습니다."));
    }
}
