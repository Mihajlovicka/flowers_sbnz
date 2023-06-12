package com.ftn.sbnz.controller;

import com.ftn.sbnz.dto.ChosenPlant;
import com.ftn.sbnz.dto.Login;
import com.ftn.sbnz.dto.RecommendPreferences;
import com.ftn.sbnz.model.plant.Plant;
import com.ftn.sbnz.service.PlantService;
import com.ftn.sbnz.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/plant")
public class PlantController {

    @Autowired private PlantService plantService;
    @Autowired
    RecommendationService recommendationService;

    @PostMapping("/new")
    public ResponseEntity newPlant(@RequestBody Plant plant){
        return new ResponseEntity(plantService.save(plant), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity all(){
        return new ResponseEntity(plantService.all(), HttpStatus.OK);
    }

    @PostMapping("/recommend")
    public ResponseEntity recommend(@RequestBody RecommendPreferences r){
        return new ResponseEntity(recommendationService.recommend(r), HttpStatus.OK);
    }

    @PostMapping("/choose")
    public ResponseEntity choose(@RequestBody ChosenPlant r){
        return new ResponseEntity(plantService.choose(r), HttpStatus.CREATED);
    }

    @GetMapping("/all/user/{email}")
    public ResponseEntity user(@PathVariable String email){
        return new ResponseEntity(plantService.userPlants(email), HttpStatus.OK);
    }

}

//dopuna profila
