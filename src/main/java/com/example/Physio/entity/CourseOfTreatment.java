package com.example.Physio.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "course_of_treatment")
public class CourseOfTreatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stuff_id",nullable = false)
    private Stuff stuff;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id",nullable = false)
    private Patient patient;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private int progressRating;
    private double muscleStrength;
    private double endurance;
    private String visitNotes;

}
