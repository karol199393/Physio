package com.example.Physio.service;

import com.example.Physio.entity.Calendar;
import com.example.Physio.repository.CalendarRepository;
import com.example.Physio.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarServiceImpl implements CalendarService {

    private final CalendarRepository calendarRepository;

    @Autowired
    public CalendarServiceImpl(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    @Override
    public List<Calendar> findAll() {
        return calendarRepository.findAll();
    }

    @Override
    public Optional<Calendar> findById(Long id) {
        return calendarRepository.findById(id);
    }

    @Override
    public Calendar save(Calendar calendar) {
        return calendarRepository.save(calendar);
    }

    @Override
    public void deleteById(Long id) {
        calendarRepository.deleteById(id);
    }
}
