package com.example.Physio.controller;


import com.example.Physio.entity.SickLeave;
import com.example.Physio.entity.User;
import com.example.Physio.service.SickLeaveService;
import com.example.Physio.service.UserService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/sickleave")
@CrossOrigin(origins = "http://localhost:3000")
public class SickLeaveController {
    SickLeaveService sickLeaveService;
    UserService userService;

    public SickLeaveController(SickLeaveService sickLeaveService, UserService userService) {
        this.sickLeaveService = sickLeaveService;
        this.userService = userService;
    }

    public void getSickLeaveById(Long id) {
        sickLeaveService.getSickLeaveById(id);
    }

    @GetMapping("/getAllSickLeaves")
    public List<SickLeave> getAllSickLeaves() {
        return sickLeaveService.getAllSickLeaves();
    }

    public void deleteSickLeaveById(Long id) {
        sickLeaveService.deleteSickLeaveById(id);
    }
    @PostMapping("/create")
    public SickLeave createSickLeave(@RequestBody Map<String, String> body) throws ChangeSetPersister.NotFoundException {
        Long userId = Long.parseLong(body.get("userId"));
        String sickleave = body.get("sick_leave");

        Optional<User> userOptional = userService.getUserById(userId);
        if (!userOptional.isPresent()) {
            throw new ChangeSetPersister.NotFoundException();
        }

        User user = userOptional.get();

        SickLeave newSickLeave = new SickLeave();
        newSickLeave.setUser(user);
        newSickLeave.setSick_leave(sickleave);

        return sickLeaveService.save(newSickLeave);
    }
}
