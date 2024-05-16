package com.example.Physio.service;

import com.example.Physio.entity.Patient;
import com.example.Physio.repository.PatientRepository;

public class LoginServiceForPatient {
    public PatientRepository patientRepository;

    public LoginServiceForPatient(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient login(String username, String password) {
        if (password != null) {
            Patient patient = patientRepository.findByUsername(username);
            if (patient != null && patient.getPassword().equals(password)) {
                return patient;
            }
            if (patient == null) {
                throw new RuntimeException("Patient cannot be null");
            }
            if (!patient.getUsername().equals(username)) {
                throw new RuntimeException("Patient not found");
            }
            if (patient.getPassword() == null)
                throw new RuntimeException("Password cannot be null");
            if (!patient.getPassword().equals(password)) {
                throw new RuntimeException("Incorrect password");
            }
            if (username == null)
                throw new RuntimeException("Username cannot be null");
        }
        return null;
    }
}
