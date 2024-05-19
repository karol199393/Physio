package com.example.Physio.service;

import com.example.Physio.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void getPatientById(Long id) {
        patientRepository.findById(id);
    }
    public void getAllPatients() {
        patientRepository.findAll();
    }
}
