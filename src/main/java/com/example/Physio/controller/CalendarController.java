package com.example.Physio.controller;

import com.example.Physio.entity.Calendar;
import com.example.Physio.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/calendars")
@CrossOrigin(origins = "http://localhost:3000")
public class CalendarController {

    private final CalendarService calendarService;

    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @GetMapping("/getAllCalendars")
    public List<Calendar> getAllCalendars() {
        return calendarService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Calendar> getCalendarById(@PathVariable Long id) {
        Optional<Calendar> calendar = calendarService.findById(id);
        return calendar.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/addCalendar")
    public Calendar createCalendar(@RequestBody Calendar calendar) {
        return calendarService.save(calendar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Calendar> updateCalendar(@PathVariable Long id, @RequestBody Calendar calendarDetails) {
        Optional<Calendar> optionalCalendar = calendarService.findById(id);
        if (optionalCalendar.isPresent()) {
            Calendar calendar = optionalCalendar.get();
            calendar.setStuff(calendarDetails.getStuff());
            calendar.setPatient(calendarDetails.getPatient());
            calendar.setDate(calendarDetails.getDate());
            return ResponseEntity.ok(calendarService.save(calendar));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCalendar(@PathVariable Long id) {
        if (calendarService.findById(id).isPresent()) {
            calendarService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
