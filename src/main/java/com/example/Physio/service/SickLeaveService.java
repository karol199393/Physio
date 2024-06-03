package com.example.Physio.service;

import com.example.Physio.entity.SickLeave;
import com.example.Physio.entity.User;
import com.example.Physio.repository.SickLeaveRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SickLeaveService {
    SickLeaveRepository sickLeaveRepository;

    public SickLeaveService(SickLeaveRepository sickLeaveRepository) {
        this.sickLeaveRepository = sickLeaveRepository;
    }

    public SickLeave getSickLeaveById(Long id) {
        return sickLeaveRepository.findById(id).orElse(null);
    }

    public List<SickLeave> getAllSickLeaves() {
        return sickLeaveRepository.findAll();
    }

    public void deleteSickLeaveById(Long id) {
        sickLeaveRepository.deleteById(id);
    }

    public SickLeave save(SickLeave sickLeave) {
        return sickLeaveRepository.save(sickLeave);
    }




}
