package com.ftn.sbnz.service;

import com.ftn.sbnz.model.enums.*;
import com.ftn.sbnz.model.enums.Sunlight;
import com.ftn.sbnz.model.enums.WateringNeeds;
import com.ftn.sbnz.model.plant.Plant;
import com.ftn.sbnz.model.plant.*;
import com.ftn.sbnz.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Arrays;

@Service
public class PlantService {

    @Autowired
    PlantRepository plantRepository;

    public void save(Plant plant) {
        plantRepository.save(plant);
    }

    public List<Plant> all() {
        return plantRepository.findAll();
    }


}
