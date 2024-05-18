package com.example.Physio.repository;

import com.example.Physio.entity.Recommendations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationsRepository extends JpaRepository<Recommendations, Long> {
}
