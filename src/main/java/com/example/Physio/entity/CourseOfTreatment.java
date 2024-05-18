package com.example.Physio.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CourseOfTreatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "stuff_id",nullable = false)
    private Stuff stuff;
    @ManyToOne
    @JoinColumn(name = "patient_id",nullable = false)
    private Patient patient;
    private String description;
    private String duration;

}
