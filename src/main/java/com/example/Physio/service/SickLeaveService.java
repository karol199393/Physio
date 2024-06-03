package com.example.Physio.service;

import com.example.Physio.entity.SickLeave;
import com.example.Physio.entity.User;
import com.example.Physio.repository.SickLeaveRepository;
import org.springframework.stereotype.Service;

@Service
public class SickLeaveService {
    SickLeaveRepository sickLeaveRepository;

    public SickLeaveService(SickLeaveRepository sickLeaveRepository) {
        this.sickLeaveRepository = sickLeaveRepository;
    }

    public User getSickLeaveById(Long id) {
        sickLeaveRepository.findById(id);
        return null;
    }

    public void getAllSickLeaves() {
        sickLeaveRepository.findAll();
    }

    public void deleteSickLeaveById(Long id) {
        sickLeaveRepository.deleteById(id);
    }

    public SickLeave save(SickLeave sickLeave) {
        sickLeaveRepository.save(sickLeave);
        return sickLeave;
    }




}
