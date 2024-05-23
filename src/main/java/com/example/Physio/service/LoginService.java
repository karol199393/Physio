package com.example.Physio.service;

import com.example.Physio.entity.User;
import com.example.Physio.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public LoginService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User login(String username, String password) {
        if (password != null) {
            User user = userRepository.findByUsername(username);
            boolean pass = passwordEncoder.matches(password, user.getPassword());
            if (user != null && pass) {
                return user;
            }
            if (user == null) {
                throw new RuntimeException("User cannot be null");
            }
            if (!user.getUsername().equals(username)) {
                throw new RuntimeException("User not found");
            }
            if (user.getPassword() == null)
                throw new RuntimeException("Password cannot be null");
            if (username == null)
                throw new RuntimeException("Username cannot be null");
        }
        return null;
    }
}