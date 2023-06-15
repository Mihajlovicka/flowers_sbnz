package com.ftn.sbnz.service;

import com.ftn.sbnz.ServiceApplication;
import com.ftn.sbnz.dto.ChosenPlant;
import com.ftn.sbnz.dto.RecommendPreferences;
import com.ftn.sbnz.model.enums.*;
import com.ftn.sbnz.model.enums.Sunlight;
import com.ftn.sbnz.model.enums.WateringNeeds;
import com.ftn.sbnz.model.plant.Plant;
import com.ftn.sbnz.model.plant.*;
import com.ftn.sbnz.model.user.User;
import com.ftn.sbnz.repository.PlantRepository;
import com.ftn.sbnz.util.DebugAgendaEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Arrays;

@Service
public class PlantService {

    private static Logger log = LoggerFactory.getLogger(ServiceApplication.class);
    @Autowired
    private KieContainer kieContainer;

    @Autowired
    PlantRepository plantRepository;
    @Autowired
    UserService userService;

//    @Autowired
//    public RecommendationService(KieContainer kieContainer) {
//        log.info("Initialising a new example session.");
//        this.kieContainer = kieContainer;
//    }

    public Plant save(Plant plant) {
        findPlantLevel(plant);
        plantRepository.save(plant);
        return plant;
    }

    private void findPlantLevel(Plant plant) {
        KieSession kieSession = kieContainer.newKieSession("level");
        kieSession.addEventListener(new DebugAgendaEventListener());
        kieSession.insert(plant);
        kieSession.fireAllRules();
    }

    public List<Plant> all() {
        return plantRepository.findAll();
    }

    public boolean choose(ChosenPlant r) {
        User u = userService.getByEmail(r.getUser());
        if(u == null) throw new RuntimeException("Korisnik ne postoji.");
        if(u.getPlants().contains(r.getPlant())) return false;
        u.addPlant(r.getPlant());
        userService.update(u);
        upScore(r.getPlant());
        return true;
    }

    private void upScore(Plant plant) {
        plant.setScore(plant.getScore()+5);
        plantRepository.save(plant);
    }


    public List<Plant> userPlants(String email) {
        return userService.getByEmail(email).getPlants();
    }

    public Plant getPlant(Long plantId){
        return plantRepository.findById(plantId).orElse(null);
    }
}
