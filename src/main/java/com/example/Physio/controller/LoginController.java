package com.example.Physio.controller;

import com.example.Physio.entity.User;
import com.example.Physio.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User user1 = loginService.login(user.getUsername(), user.getPassword());
        if(user1 != null){
            return ResponseEntity.ok(user1);
        }
        return ResponseEntity.status(200).build();
    }
}