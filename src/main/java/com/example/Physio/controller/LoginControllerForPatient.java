package com.example.Physio.controller;


import com.example.Physio.entity.Patient;
import com.example.Physio.service.LoginServiceForPatient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginControllerForPatient {

    LoginServiceForPatient loginServiceForPatient;

    public LoginControllerForPatient(LoginServiceForPatient loginServiceForPatient) {
        this.loginServiceForPatient = loginServiceForPatient;
    }

    @RequestMapping("/loginForPatient")
    public ResponseEntity<Patient> loginForPatient(@RequestBody Patient patient) {
        Patient patient1 = loginServiceForPatient.login(patient.getUsername(), patient.getPassword());
        if(patient1!=null){
            return ResponseEntity.ok(patient1);
        }
        return ResponseEntity.status(401).build();
    }



}
