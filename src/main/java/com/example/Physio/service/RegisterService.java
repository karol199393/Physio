package com.example.Physio.service;


import com.example.Physio.entity.RegisterRequest;
import com.example.Physio.entity.Role;
import com.example.Physio.entity.User;
import com.example.Physio.repository.RoleRepository;
import com.example.Physio.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterService {
    public UserRepository userRepository;
    public RoleRepository roleRepository;
    public PasswordEncoder encoder;

    public RegisterService(UserRepository userRepository,RoleRepository roleRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User registerUser(RegisterRequest userRequest) {
        if(userRequest.getEmail() == null && userRequest.getUsername() == null && userRequest.getPassword() == null ) {
            throw new RuntimeException("Username or password cannot be null");
        }
        Optional<User> existingUser = Optional.ofNullable(userRepository.findByUsername(userRequest.getUsername()));
        if (existingUser.isPresent()) {
            throw new RuntimeException("User already exists");
        }

        Long roleId = userRequest.getRoleId();
        if (roleId == null) {
            throw new IllegalArgumentException("Role ID cannot be null");
        }

        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        userRequest.setPassword(encoder.encode(userRequest.getPassword()));
        User newUser = new User();
        newUser.setUsername(userRequest.getUsername());
        newUser.setPassword(userRequest.getPassword());
        newUser.setEmail(userRequest.getEmail());
        newUser.setRole(role);
        return userRepository.save(newUser);
    }
}


