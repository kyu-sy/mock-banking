package com.financial.security.mock_banking.service;

import com.financial.security.mock_banking.domain.User;
import com.financial.security.mock_banking.repository.UserRepository;
import com.financial.security.mock_banking.domain.Role;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User registerUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("이미 사용 중인 아이디입니다.");
        }

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        user.setRole(Role.ROLE_USER);

        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }



}

