package com.example.Physio.service;

import com.example.Physio.repository.StuffRepository;

public class LoginServiceForStuff {
    public StuffRepository stuffRepository;

    public LoginServiceForStuff(StuffRepository stuffRepository){
        this.stuffRepository=stuffRepository;
    }



}
