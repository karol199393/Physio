package com.example.Physio.repository;

import com.example.Physio.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByUsername(String username);
}
