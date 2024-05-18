package com.example.Physio.service;


import com.example.Physio.entity.Recommendations;
import com.example.Physio.repository.RecommendationsRepository;
import org.springframework.stereotype.Service;

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
}