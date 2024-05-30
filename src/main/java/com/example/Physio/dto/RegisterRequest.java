package com.example.Physio.dto;

import com.example.Physio.entity.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RegisterRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private Long role;

    public RegisterRequest(String username, String password, String email, Long roleId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = roleId;
    }

    public RegisterRequest() {
    }
}

