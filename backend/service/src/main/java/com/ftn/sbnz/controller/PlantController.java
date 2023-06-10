package com.ftn.sbnz.controller;

import com.ftn.sbnz.dto.Login;
import com.ftn.sbnz.model.plant.Plant;
import com.ftn.sbnz.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/plant")
public class PlantController {

    @Autowired private PlantService plantService;

    @PostMapping("/new")
    public ResponseEntity register(@RequestBody Plant plant){
        plantService.save(plant);
        return new ResponseEntity(null, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity all(){
        return new ResponseEntity(plantService.all(), HttpStatus.OK);
    }
}
