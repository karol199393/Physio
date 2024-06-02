package com.example.Physio.service;


import com.example.Physio.entity.Recommendations;
import com.example.Physio.repository.RecommendationsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@Service
public class RecommendationsService {

    private final RecommendationsRepository recommendationsRepository;

    public RecommendationsService(RecommendationsRepository recommendationsRepository) {
        this.recommendationsRepository = recommendationsRepository;
    }

    public Recommendations save(Recommendations recommendations) {
        return recommendationsRepository.save(recommendations);
    }

    public List<Recommendations> findAll() {
        return recommendationsRepository.findAll();
    }

    public Optional<Recommendations> findById(Long id) {
        return recommendationsRepository.findById(id);
    }

    public void deleteById(Long id) {
        recommendationsRepository.deleteById(id);
    }

    public ResponseEntity<Recommendations> updateRecommendations(Long id, Recommendations recommendations) {
        Optional<Recommendations> recommendationsData = recommendationsRepository.findById(id);

        if (recommendationsData.isPresent()) {
            Recommendations _recommendations = recommendationsData.get();
            _recommendations.setRecommendation(recommendations.getRecommendation());
            return ResponseEntity.ok(recommendationsRepository.save(_recommendations));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Recommendations> assignRecommendationsToPatient(Long id, Recommendations recommendations) {
        Optional<Recommendations> recommendationsData = recommendationsRepository.findById(id);

        if (recommendationsData.isPresent()) {
            Recommendations _recommendations = recommendationsData.get();
            _recommendations.setRecommendation(recommendations.getRecommendation());
            return ResponseEntity.ok(recommendationsRepository.save(_recommendations));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Recommendations> getUserByRecommendation(Long id) {
        Optional<Recommendations> recommendations = recommendationsRepository.findById(id);
        return recommendations.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}