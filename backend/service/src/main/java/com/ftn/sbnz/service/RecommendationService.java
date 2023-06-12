package com.ftn.sbnz.service;

import com.ftn.sbnz.ServiceApplication;
import com.ftn.sbnz.dto.RecommendPreferences;
import com.ftn.sbnz.model.disease.SpacingBad;
import com.ftn.sbnz.model.disease.SpacingGood;
import com.ftn.sbnz.model.drools.PlantRec;
import com.ftn.sbnz.model.drools.UserPlant;
import com.ftn.sbnz.model.enums.SpaceNeed;
import com.ftn.sbnz.model.plant.Plant;
import com.ftn.sbnz.model.user.User;
import com.ftn.sbnz.util.DebugAgendaEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.mvel2.util.Make;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

@Service
public class RecommendationService {

    private static Logger log = LoggerFactory.getLogger(ServiceApplication.class);
    private final KieContainer kieContainer;
    
    @Autowired PlantService plantService;
    @Autowired UserService userService;

    @Autowired
    public RecommendationService(KieContainer kieContainer) {
        log.info("Initialising a new example session.");
        this.kieContainer = kieContainer;
    }

    public List<PlantRec> recommend(RecommendPreferences r) {
        KieSession kieSession = kieContainer.newKieSession("forward");
        kieSession.addEventListener(new DebugAgendaEventListener());
        insertPlants(kieSession);
        insertPlantSpacing(kieSession);
        insertUserStuff(kieSession, r);

        HashMap<Long, PlantRec> recommendedPlants = new HashMap<>();
        kieSession.setGlobal("recommendedPlants", recommendedPlants);
        kieSession.insert(recommendedPlants);

        kieSession.fireAllRules();
        for (Long k : recommendedPlants.keySet()) {
            System.out.println("k: " + k + " v: " + recommendedPlants.get(k).getPoints());
        }
        kieSession.dispose();

        return getSorted(recommendedPlants);
    }

    private void insertUserStuff(KieSession kieSession, RecommendPreferences r) {
        User u = userService.getByEmail(r.getUser());
        if(u == null) throw new RuntimeException("Korisnik ne postoji.");
        kieSession.insert(u.getPlantCareUserForm());
        kieSession.insert(r.getLook());
        kieSession.insert(r.getEnv());

        for(Plant p: u.getPlants()){
            kieSession.insert(new UserPlant(p.getId()));
        }

    }

    private void insertPlants(KieSession kieSession){
        for(Plant p: plantService.all()){
            kieSession.insert(p);
        }
    }
    
    private void insertPlantSpacing(KieSession kieSession){
        kieSession.insert(new SpacingGood(SpaceNeed.COMPACT, SpaceNeed.VERTICAL));
        kieSession.insert(new SpacingGood(SpaceNeed.COMPACT, SpaceNeed.COMPACT));
        kieSession.insert(new SpacingGood(SpaceNeed.MODERATE, SpaceNeed.VERTICAL));
        kieSession.insert(new SpacingGood(SpaceNeed.MODERATE, SpaceNeed.MODERATE));
        kieSession.insert(new SpacingGood(SpaceNeed.VERTICAL, SpaceNeed.VERTICAL));
        kieSession.insert(new SpacingGood(SpaceNeed.DENSE, SpaceNeed.UNDERGROUND));
        kieSession.insert(new SpacingGood(SpaceNeed.MODERATE, SpaceNeed.AGGRESSIVE));
        kieSession.insert(new SpacingBad(SpaceNeed.COMPACT, SpaceNeed.AGGRESSIVE));
        kieSession.insert(new SpacingBad(SpaceNeed.DENSE, SpaceNeed.MODERATE));
        kieSession.insert(new SpacingBad(SpaceNeed.AGGRESSIVE, SpaceNeed.VERTICAL));
        kieSession.insert(new SpacingBad(SpaceNeed.DENSE, SpaceNeed.COMPACT));
        kieSession.insert(new SpacingBad(SpaceNeed.DENSE, SpaceNeed.AGGRESSIVE));
        kieSession.insert(new SpacingBad(SpaceNeed.DENSE, SpaceNeed.VERTICAL));
        kieSession.insert(new SpacingBad(SpaceNeed.DENSE, SpaceNeed.DENSE));
        kieSession.insert(new SpacingBad(SpaceNeed.AGGRESSIVE, SpaceNeed.AGGRESSIVE));
    }


    private List<PlantRec> getSorted(HashMap<Long, PlantRec> recommendedPlants){
        List<PlantRec> plantRecList = new ArrayList<>(recommendedPlants.values());
        plantRecList.sort(Comparator.comparingDouble(PlantRec::getPoints));
        return plantRecList;
    }
}
