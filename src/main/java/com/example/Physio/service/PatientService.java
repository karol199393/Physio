package com.example.Physio.service;

import com.example.Physio.entity.Patient;
import com.example.Physio.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Patient> findBySurname(String surname) {
        return patientRepository.findBySurname(surname);
    }
    public void findByEmail(String email) {
        patientRepository.findByEmail(email);
    }
    public void findByUsername(String username) {
        patientRepository.findByUsername(username);
    }
    public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
    public void updatePatient(Long id, Patient patient) {
        Patient existingPatient = patientRepository.findById(id).orElse(null);
        existingPatient.setName(patient.getName());
        existingPatient.setSurname(patient.getSurname());
        existingPatient.setEmail(patient.getEmail());
        existingPatient.setUsername(patient.getUsername());
        existingPatient.setPassword(patient.getPassword());
        patientRepository.save(existingPatient);
    }
}
