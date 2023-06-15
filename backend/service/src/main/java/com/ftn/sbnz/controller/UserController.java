package com.ftn.sbnz.controller;

import com.ftn.sbnz.dto.Login;
import com.ftn.sbnz.model.user.PlantCareUserForm;
import com.ftn.sbnz.model.user.User;
import com.ftn.sbnz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired private UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody User user){
        userService.register(user);
        return new ResponseEntity(null, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity register(@RequestBody Login login){
        return new ResponseEntity( userService.login(login.getEmail(), login.getPassword()), HttpStatus.OK);
    }


    @GetMapping("/get/{email}")
    public ResponseEntity get(@PathVariable String email){
        return new ResponseEntity( userService.getByEmail(email), HttpStatus.OK);
    }
}
