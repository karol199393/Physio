package com.example.Physio.dto;

import com.example.Physio.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String username;
    private String password;
    private String email;
    private Long role;

    public RegisterRequest(String username, String password, String email,Long roleId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
}
