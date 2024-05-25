package com.example.Physio.controller;

import com.example.Physio.entity.Recommendations;
import com.example.Physio.service.RecommendationsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/recommendations")
@CrossOrigin(origins = "http://localhost:3000")
public class RecommendationsController {

    private final RecommendationsService recommendationsService;

    public RecommendationsController(RecommendationsService recommendationsService) {
        this.recommendationsService = recommendationsService;
    }

    @PostMapping("/create")
    public Recommendations createRecommendation(@RequestBody Recommendations recommendations) {
        return recommendationsService.save(recommendations);
    }

    @GetMapping("/getAllRec")
    public List<Recommendations> getAllRecommendations() {
        return recommendationsService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recommendations> getRecommendationById(@PathVariable Long id) {
        Optional<Recommendations> recommendations = recommendationsService.findById(id);
        return recommendations.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Recommendations> updateRecommendation(@PathVariable Long id, @RequestBody Recommendations recommendationsDetails) {
        Optional<Recommendations> optionalRecommendations = recommendationsService.findById(id);
        if (optionalRecommendations.isPresent()) {
            Recommendations recommendations = optionalRecommendations.get();
            recommendations.setRecommendation(recommendationsDetails.getRecommendation());
            return ResponseEntity.ok(recommendationsService.save(recommendations));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecommendation(@PathVariable Long id) {
        if (recommendationsService.findById(id).isPresent()) {
            recommendationsService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}