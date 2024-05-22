package com.example.Physio.controller;

import com.example.Physio.entity.CourseOfTreatment;
import com.example.Physio.service.CourseOfTreatmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/courseOfTreatment")
@CrossOrigin(origins = "http://localhost:3000")
public class CourseOfTreatmentController {
    CourseOfTreatmentService courseOfTreatmentService;

    public CourseOfTreatmentController(CourseOfTreatmentService courseOfTreatmentService) {
        this.courseOfTreatmentService = courseOfTreatmentService;
    }

    @PostMapping("/create")
    public CourseOfTreatment createCourseOfTreatment(@RequestBody CourseOfTreatment courseOfTreatment) {
        return courseOfTreatmentService.createCourseOfTreatment(courseOfTreatment);
    }

    @GetMapping("/patient/{id}")
    public List<CourseOfTreatment> getCourseOfTreatmentByPatientId(@PathVariable Long id) {
        return courseOfTreatmentService.getCourseOfTreatmentById(id);
    }
}
