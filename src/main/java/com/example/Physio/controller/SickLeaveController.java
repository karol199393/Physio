package com.example.Physio.controller;


import com.example.Physio.entity.Recommendations;
import com.example.Physio.entity.SickLeave;
import com.example.Physio.entity.User;
import com.example.Physio.service.SickLeaveService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/sickleave")
@CrossOrigin(origins = "http://localhost:3000")
public class SickLeaveController {
    SickLeaveService sickLeaveService;

    public SickLeaveController(SickLeaveService sickLeaveService) {
        this.sickLeaveService = sickLeaveService;
    }

    public void getSickLeaveById(Long id) {
        sickLeaveService.getSickLeaveById(id);
    }

    public void getAllSickLeaves() {
        sickLeaveService.getAllSickLeaves();
    }

    public void deleteSickLeaveById(Long id) {
        sickLeaveService.deleteSickLeaveById(id);
    }
    @PostMapping("/create")
    public SickLeave createSickLeave(@RequestBody Map<String, String> body) throws ChangeSetPersister.NotFoundException {
        Long userId = Long.parseLong(body.get("userId"));
        String sickleave = body.get("sick_leave");

        User user = sickLeaveService.getSickLeaveById(userId);
        if (user == null) {
            throw new ChangeSetPersister.NotFoundException();
        }

        SickLeave newSickLeave = new SickLeave();
        newSickLeave.setUser(user);
        newSickLeave.setSick_leave(sickleave);

        return sickLeaveService.save(newSickLeave);
    }
}
