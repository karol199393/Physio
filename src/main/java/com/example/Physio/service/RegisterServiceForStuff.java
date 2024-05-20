package com.example.Physio.service;

import com.example.Physio.dto.RegisterRequest;
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

    public Stuff registerStuff(RegisterRequest stuff) {
        if(stuff.getEmail() == null|| stuff.getUsername() == null|| stuff.getPassword() == null ) {
            throw new RuntimeException("Username or password cannot be null");
        }
        Optional<Stuff> existingStuff = Optional.ofNullable(stuffRepository.findByUsername(stuff.getUsername()));
        if (existingStuff.isPresent()) {
            throw new RuntimeException("Stuff already exists");
        }
        stuff.setPassword(encoder.encode(stuff.getPassword()));
        Stuff newStuff = new Stuff();
        newStuff.setUsername(stuff.getUsername());
        newStuff.setPassword(stuff.getPassword());
        newStuff.setEmail(stuff.getEmail());
        return stuffRepository.save(newStuff);
    }
}
