package com.example.Physio.controller;

import com.example.Physio.dto.RegisterRequest;
import com.example.Physio.entity.Patient;
import com.example.Physio.entity.Stuff;
import com.example.Physio.service.RegisterServiceForStuff;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class RegisterControllerForStuff {
    private RegisterServiceForStuff registerServiceForStuff;

    public RegisterControllerForStuff(RegisterServiceForStuff registerServiceForStuff) {
        this.registerServiceForStuff = registerServiceForStuff;
    }


    @PostMapping("/registerStuff")
    public ResponseEntity<Stuff> registerStuff(@RequestBody RegisterRequest registerRequest) {
        Stuff registeredUser = registerServiceForStuff.registerStuff(registerRequest);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }
}
