package com.example.Physio.service;

import com.example.Physio.entity.Patient;
import com.example.Physio.repository.PatientRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceForPatient {
    public PatientRepository patientRepository;
    PasswordEncoder passwordEncoder;

    public LoginServiceForPatient(PatientRepository patientRepository,PasswordEncoder passwordEncoder) {
        this.patientRepository = patientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Patient login(String username, String password) {

        if (password != null) {
            Patient patient = patientRepository.findByUsername(username);
            boolean pass=passwordEncoder.matches(password, patient.getPassword());
            if (patient != null && pass) {
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

            if (username == null)
                throw new RuntimeException("Username cannot be null");
        }
        return null;
    }
}
