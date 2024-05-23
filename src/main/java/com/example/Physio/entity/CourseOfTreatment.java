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
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private int progressRating;
    private double muscleStrength;
    private double endurance;
    private String visitNotes;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}