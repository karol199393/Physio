package com.example.Physio.service;

import com.example.Physio.entity.Stuff;
import com.example.Physio.repository.StuffRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterServiceForStuff {
    public StuffRepository stuffRepository;
    public PasswordEncoder encoder;

    public RegisterServiceForStuff(StuffRepository stuffRepository, PasswordEncoder encoder) {
        this.stuffRepository = stuffRepository;
        this.encoder = encoder;
    }
    public void deleteStuff(Long id) {
        stuffRepository.deleteById(id);
    }

    public Stuff registerStuff(Stuff stuff) {
        if(stuff.getName() == null || stuff.getName() == null|| stuff.getPassword() == null ||stuff.getEmail() == null) {
            throw new RuntimeException("Username or password cannot be null");
        }
        Optional<Stuff> existingStuff = Optional.ofNullable(stuffRepository.findByUsername(stuff.getSurname()));
        if (existingStuff.isPresent()) {
            throw new RuntimeException("Stuff already exists");
        }
        stuff.setPassword(encoder.encode(stuff.getPassword()));
        return stuffRepository.save(stuff);
    }
}
