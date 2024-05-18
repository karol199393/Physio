package com.example.Physio.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Recommendations {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id",nullable = false)
    private Patient patient;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stuff_id",nullable = false)
    private Stuff stuff;
    private String recommendation;
}
