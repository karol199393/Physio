package com.example.Physio.repository;


import com.example.Physio.entity.CourseOfTreatment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseOfTreatmentRepository extends JpaRepository<CourseOfTreatment, Long> {
    CourseOfTreatment findByName(String name);
    List<CourseOfTreatment> findByPatientId(Long id);
}
