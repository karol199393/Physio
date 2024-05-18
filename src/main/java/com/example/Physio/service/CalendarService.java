package com.example.Physio.service;

import com.example.Physio.entity.Calendar;

import java.util.List;
import java.util.Optional;

public interface CalendarService {
    List<Calendar> findAll();
    Optional<Calendar> findById(Long id);
    Calendar save(Calendar calendar);
    void deleteById(Long id);
}
