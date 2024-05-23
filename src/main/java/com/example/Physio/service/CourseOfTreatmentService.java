package com.example.Physio.service;

import com.example.Physio.entity.CourseOfTreatment;
import com.example.Physio.repository.CourseOfTreatmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CourseOfTreatmentService {
    CourseOfTreatmentRepository courseOfTreatmentRepository;

    public CourseOfTreatmentService(CourseOfTreatmentRepository courseOfTreatmentRepository) {
        this.courseOfTreatmentRepository = courseOfTreatmentRepository;
    }

    public List<CourseOfTreatment> getCourseOfTreatmentById(@PathVariable Long id) {
        return courseOfTreatmentRepository.findByUserId(id);
    }

    public CourseOfTreatment createCourseOfTreatment(CourseOfTreatment courseOfTreatment) {
        return courseOfTreatmentRepository.save(courseOfTreatment);
    }




}
