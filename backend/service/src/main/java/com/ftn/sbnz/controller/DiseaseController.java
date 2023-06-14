package com.ftn.sbnz.controller;

import com.ftn.sbnz.model.plant.Plant;
import com.ftn.sbnz.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/disease")
public class DiseaseController {

    @Autowired
    DiseaseService diseaseService;

    @PostMapping("/diagnose")
    public ResponseEntity diagnose(@RequestBody ArrayList<String> symptoms){

        return new ResponseEntity(diseaseService.diagnose(symptoms), HttpStatus.OK);
    }

    @GetMapping("/get/symptoms")
    public ResponseEntity getSymptoms(){
        return new ResponseEntity(diseaseService.getSymptoms(), HttpStatus.OK);
    }

}

//najvise odgovarajuca bolest -- ona sa najvise simptoma
//ispis svih tretmana
//ispis uzroka
//samo uniqe

//koliko je koja bolest zastupljena kod koje biljke
//glavni uzrok da stavim prvi koji je

//npr dodao je neke simptome biljci
//ocenio da je biljka super i da raste
//uklonio simptome
