package com.example.Physio.repository;


import com.example.Physio.entity.CourseOfTreatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseOfTreatmentRepository extends JpaRepository<CourseOfTreatment, Long> {
    public CourseOfTreatment findByName(String name);
}
