package com.example.Physio.controller;

import com.example.Physio.entity.Stuff;
import com.example.Physio.service.LoginServiceForStuff;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginControllerForStuff {
    private LoginServiceForStuff loginServiceForStuff;

    public LoginControllerForStuff(LoginServiceForStuff loginServiceForStuff) {
        this.loginServiceForStuff = loginServiceForStuff;
    }

    @RequestMapping("/loginForStuff")
    public ResponseEntity<Stuff> loginForStuff(@RequestBody Stuff stuff) {
        Stuff stuff1 = loginServiceForStuff.login(stuff.getUsername(), stuff.getPassword());
        if(stuff1!=null){
            return ResponseEntity.ok(stuff1);
        }
        return ResponseEntity.status(200).build();
    }

}
