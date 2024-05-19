package com.example.Physio.service;

import com.example.Physio.repository.StuffRepository;
import org.springframework.stereotype.Service;

@Service
public class StuffService {
    private StuffRepository stuffRepository;

    public StuffService(StuffRepository stuffRepository) {
        this.stuffRepository = stuffRepository;
    }

    public void getStuffById(Long id) {
        stuffRepository.findById(id);
    }
    public void getAllStuffs() {
        stuffRepository.findAll();
    }
}

