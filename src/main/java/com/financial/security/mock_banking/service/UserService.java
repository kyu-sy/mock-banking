package com.financial.security.mock_banking.service;

import com.financial.security.mock_banking.domain.User;
import com.financial.security.mock_banking.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User registerUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("이미 사용 중인 아이디입니다.");

        }
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }



}

