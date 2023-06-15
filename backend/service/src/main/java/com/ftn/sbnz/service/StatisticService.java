package com.ftn.sbnz.service;

import com.ftn.sbnz.model.back2.Symptom;
import com.ftn.sbnz.model.plant.Plant;
import com.ftn.sbnz.model.user.NegativeReview;
import com.ftn.sbnz.model.user.PositiveReview;
import com.ftn.sbnz.model.user.Statistic;
import com.ftn.sbnz.model.user.User;
import com.ftn.sbnz.repository.NegativeReviewRepository;
import com.ftn.sbnz.repository.PositiveReviewRepository;
import com.ftn.sbnz.repository.StatisticRepository;
import com.ftn.sbnz.util.DebugAgendaEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StatisticService {
    @Autowired StatisticRepository statisticRepository;
    @Autowired PositiveReviewRepository positiveReviewRepository;
    @Autowired NegativeReviewRepository negativeReviewRepository;
    @Autowired UserService userService;
    @Autowired PlantService plantService;
    @Autowired DiseaseService diseaseService;


    @Autowired
    private KieContainer kieContainer;

    public User changeLevel(String email){
        KieSession kieSession = kieContainer.newKieSession("userLevel");
        kieSession.addEventListener(new DebugAgendaEventListener());
        User user = userService.getByEmail(email);
        if(user == null)throw new RuntimeException("Korisnik nije pronadjen.");
        kieSession.insert(user);
        List<Statistic> s = statisticRepository.findByUser(user);
        s.forEach(ss  -> {
            kieSession.insert(ss);
            ss.getPositive().forEach(kieSession::insert);
            ss.getNegative().forEach(kieSession::insert);
        });
        kieSession.fireAllRules();
        kieSession.dispose();
        userService.update(user);
        return user;
    }

    public Statistic addNewStatistic(Long plantId, String email){
        Plant plant = plantService.getPlant(plantId);
        User user = userService.getByEmail(email);
        if(plant == null || user == null) throw new RuntimeException("Korisnik ili bijka nisu pronadjeni.");
        if(!user.getPlants().contains(plant)) throw new RuntimeException("Biljka nije u kolekciji.");;
        Statistic s = new Statistic(plant, user);
        statisticRepository.save(s);
        return s;
    }


    public Statistic getStatistic(Long plantId, String email){
        Plant plant = plantService.getPlant(plantId);
        User user = userService.getByEmail(email);
        if(plant == null || user == null) throw new RuntimeException("Korisnik ili bijka nisu pronadjeni.");
        Statistic s = statisticRepository.findStatisticByUserAndPlant(user, plant).orElse(null);
        if(s == null){
            addNewStatistic(plantId, email);
            throw new RuntimeException("Statistika ne postoji.");
        } else
        return s;
    }

    public Statistic addPositive(Long plantId, String email, String positiveReview){
        Statistic s = getStatistic(plantId, email);
        PositiveReview positiveReview1 = new PositiveReview(positiveReview);
        s.addPositive(positiveReview1);
        positiveReviewRepository.save(positiveReview1);
        statisticRepository.save(s);
        return s;
    }

    public Statistic addNegative(Long plantId, String email, String negativeReview){
        Statistic s = getStatistic(plantId, email);
        NegativeReview negativeReview1 = new NegativeReview(
                diseaseService.getSymptom(negativeReview)
        );
        negativeReviewRepository.save(negativeReview1);
        s.addNegative(negativeReview1);
        statisticRepository.save(s);
        return s;
    }

    public Statistic handleNegative(Long plantId, String email,String comment, Date date ) throws ParseException {
        Statistic s = getStatistic(plantId, email);
        for(NegativeReview negativeReview1: s.getNegative()){
            Symptom symptom = diseaseService.getSymptom(comment);
            SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String dateS = formatter1.format(negativeReview1.getDate());
            Date date1 = formatter1.parse(dateS);
            if(negativeReview1.getSymptom().equals(symptom) && date1.equals(date)){
                negativeReview1.setHandled(true);
                negativeReview1.setDateHandled(new Date());
                negativeReviewRepository.save(negativeReview1);
                break;
            }
        }
        statisticRepository.save(s);
        return s;
    }

}
