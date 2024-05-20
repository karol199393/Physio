package com.example.Physio.controller;

import com.example.Physio.entity.Patient;
import com.example.Physio.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
@CrossOrigin(origins = "http://localhost:3000")
public class PatientController {
    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    @GetMapping("/getAll")
    public void getAllPatients() {
        patientService.getAllPatients();
    }
    @GetMapping("/getPatientBySurname/{surname}")
    public ResponseEntity<List<Patient>> getPatientBySurname(@PathVariable String surname) {
        List<Patient> patients = patientService.findBySurname(surname);
        if (patients.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(patients);
        }
    }
}
