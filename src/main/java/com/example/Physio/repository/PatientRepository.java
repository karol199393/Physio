package com.example.Physio.repository;

import com.example.Physio.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByUsername(String username);

    Patient findByEmail(String email);

    List<Patient> findBySurname(String surname);
}
