package com.example.Physio.service;

import com.example.Physio.entity.Stuff;
import com.example.Physio.repository.StuffRepository;

public class LoginServiceForStuff {
    public StuffRepository stuffRepository;

    public LoginServiceForStuff(StuffRepository stuffRepository){
        this.stuffRepository=stuffRepository;
    }

    public Stuff login(String username, String password) {
        if(password!=null) {
            Stuff stuff = stuffRepository.findByUsername(username);
            if (stuff != null && stuff.getPassword().equals(password)) {
                return stuff;
            }
            if (stuff == null) {
                throw new RuntimeException("Stuff cannot be null");
            }
            if (!stuff.getUsername().equals(username)) {
                throw new RuntimeException("Stuff not found");
            }
            if (stuff.getPassword() == null)
                throw new RuntimeException("Password cannot be null");
            if (!stuff.getPassword().equals(password)) {
                throw new RuntimeException("Incorrect password");
            }
            if (username == null)
                throw new RuntimeException("Username cannot be null");

        }
        return null;
    }



}
