package com.example.Physio.service;

import com.example.Physio.dto.RegisterRequest;
import com.example.Physio.entity.Patient;
import com.example.Physio.repository.PatientRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterServiceForPatient {
    public PatientRepository patientRepository;
    public PasswordEncoder encoder;

    public RegisterServiceForPatient(PatientRepository patientRepository, PasswordEncoder encoder) {
        this.patientRepository = patientRepository;
        this.encoder = encoder;
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
    public Patient registerPatient(RegisterRequest patient) {
        if(patient.getEmail() == null && patient.getUsername() == null && patient.getPassword() == null ) {
            throw new RuntimeException("Username or password cannot be null");
        }
        Optional<Patient> existingPatient = Optional.ofNullable(patientRepository.findByUsername(patient.getUsername()));
        if (existingPatient.isPresent()) {
            throw new RuntimeException("Patient already exists");
        }
        patient.setPassword(encoder.encode(patient.getPassword()));
        Patient newPatient = new Patient();
        newPatient.setUsername(patient.getUsername());
        newPatient.setPassword(patient.getPassword());
        newPatient.setEmail(patient.getEmail());
        return patientRepository.save(newPatient);
    }

}
