package com.example.Physio.controller;

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
    public Patient registerPatient(Patient patient) {
        if(patient.getName() == null || patient.getSurname() == null || patient.getPassword() == null ||patient.getEmail() == null) {
            throw new RuntimeException("Username or password cannot be null");
        }
        Optional<Patient> existingPatient = Optional.ofNullable(patientRepository.findByUsername(patient.getSurname()));
        if (existingPatient.isPresent()) {
            throw new RuntimeException("Patient already exists");
        }
        patient.setPassword(encoder.encode(patient.getPassword()));
        return patientRepository.save(patient);
    }

}
