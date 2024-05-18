package com.example.Physio.controller;

import com.example.Physio.entity.Patient;
import com.example.Physio.service.RegisterServiceForPatient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class RegisterControllerForPatient {
    private RegisterServiceForPatient registerServiceForPatient;

    public RegisterControllerForPatient(RegisterServiceForPatient registerServiceForPatient) {
        this.registerServiceForPatient = registerServiceForPatient;
    }

    @PostMapping("/registerPatient")
    public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient) {
        Patient registeredPatient = registerServiceForPatient.registerPatient(patient);
        return new ResponseEntity<>(registeredPatient, HttpStatus.CREATED);
    }

}
