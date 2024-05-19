package com.example.Physio.controller;

import com.example.Physio.service.StuffService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/recommendations")
@CrossOrigin(origins = "http://localhost:3000")
public class StuffController {
    StuffService stuffService;

    public StuffController(StuffService stuffService) {
        this.stuffService = stuffService;
    }

    @GetMapping("/getAll")
    public void getAllStuff() {
        stuffService.getAllStuffs();
    }
}
