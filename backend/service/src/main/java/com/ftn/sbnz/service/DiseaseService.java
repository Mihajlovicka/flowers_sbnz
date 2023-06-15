package com.ftn.sbnz.service;

import com.ftn.sbnz.model.back2.Disease;
import com.ftn.sbnz.model.back2.DiseaseSymptom;
import com.ftn.sbnz.model.back2.SubDisease;
import com.ftn.sbnz.model.back2.Symptom;
import com.ftn.sbnz.model.drools.BackwardGroupedDiseases;
import com.ftn.sbnz.repository.DiseaseRepository;
import com.ftn.sbnz.repository.DiseaseSymptomRepository;
import com.ftn.sbnz.repository.SubDiseaseRepository;
import com.ftn.sbnz.repository.SymptomRepository;
import com.ftn.sbnz.util.DebugAgendaEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class DiseaseService {
    
    @Autowired
    DiseaseRepository diseaseRepository;

    @Autowired
    SubDiseaseRepository subDiseaseRepository;

    @Autowired
    SymptomRepository symptomRepository;

    @Autowired
    DiseaseSymptomRepository diseaseSymptomRepository;

    @Autowired
    private KieContainer kieContainer;

    public Symptom getSymptom(String symptom){
        return symptomRepository.findSymptomBySymptom(symptom).orElseThrow(() -> new RuntimeException("Simptom ne postoji."));
    }
    
    public void saveDisease(){
        Disease glavnaDisease = new Disease("zutiranje lisca");
        glavnaDisease.setTop(true);
        Disease podDisease1 = new Disease("Nedostatak svetlosti");
        Disease podDisease2 = new Disease("Visak zalivanja");
        Disease podDisease3 = new Disease("Nedostatak hranljivih materija");
        Disease podpodDisease31 = new Disease("Nedostatak gvozdja");
        Disease podpodDisease32 = new Disease("Nedostatak azota");
        Disease podDisease4 = new Disease("Biljna bolest");
        Disease podpodDisease41 = new Disease("Infekcija patogenom (npr. gljivicom)");

        Disease glavnaDisease1 = new Disease("Listna trulez");
        glavnaDisease1.setTop(true);
        Disease podDisease5 = new Disease("Infekcija bakterijama");
        Disease podDisease6 = new Disease("Bolest uzrokovana stetocinama");
        Disease podpodDisease61 = new Disease("Infestacija lisnih usi");
        Disease podpodDisease62 = new Disease("Infestacija grinja");

        SubDisease subDisease = new SubDisease(podDisease1, glavnaDisease);
        SubDisease subDisease1 = new SubDisease(podDisease2, glavnaDisease);
        SubDisease subDisease2 = new SubDisease(podDisease3, glavnaDisease);
        SubDisease subDisease3 = new SubDisease(podpodDisease31, podDisease3);
        SubDisease subDisease4 = new SubDisease(podpodDisease32, podDisease3);
        SubDisease subDisease5 = new SubDisease(podDisease4, glavnaDisease);
        SubDisease subDisease6 = new SubDisease(podpodDisease41, podDisease4);

        SubDisease subDisease7 = new SubDisease(podDisease4, glavnaDisease1);
        SubDisease subDisease8 = new SubDisease(podDisease5, glavnaDisease1);
        SubDisease subDisease9 = new SubDisease(podDisease6, glavnaDisease1);
        SubDisease subDisease10 = new SubDisease(podpodDisease61, podDisease6);
        SubDisease subDisease11 = new SubDisease(podpodDisease62, podDisease6);
        SubDisease subDisease12 = new SubDisease(podDisease3, glavnaDisease1);

        Symptom s = new Symptom("tamne mrlje i trulez na liscu","Infekcija patogenom (npr. gljivicom)", "Uklanjanje ostecenog lisca i primena fungicida");
        DiseaseSymptom d = new DiseaseSymptom(s, podpodDisease41);

        Symptom s1 = new Symptom("Vodenaste mrlje na liscu","Infekcija bakterijama", "Uklanjanje ostecenog lisca i primena baktericidnog sredstva");
        DiseaseSymptom d1 = new DiseaseSymptom(s1, podDisease5);

        Symptom s2 = new Symptom("Pojava malih, zelenih insekata na liscu","Infestacija lisnih usi", "Prskanje insekticidom ili prirodni repelenti");
        DiseaseSymptom d2 = new DiseaseSymptom(s2, podpodDisease61);

        Symptom s3 = new Symptom("Pojava sitnih crvenih tackica na liscu","Infestacija grinja", "Prskanje akaricidom i odrzavanje odgovarajuce vlaznosti");
        DiseaseSymptom d3 = new DiseaseSymptom(s3, podpodDisease62);

        Symptom s4 = new Symptom("zutiranje i opadanje lisca","Nedovoljna kolicina svetlosti", "Premestite biljku na osvetljeno mesto");
        DiseaseSymptom d4 = new DiseaseSymptom(s4, podDisease1);

        Symptom s5 = new Symptom("zutiranje i venusce lisca","Prekomerno zalivanje","Smanjite ucestalost zalivanja i proverite drenazu");
        DiseaseSymptom d5 = new DiseaseSymptom(s5, podDisease2);

        Symptom s6 = new Symptom("zutiranje lisca sa tamnim venama","Nedostatak odredjenih hranljivih materija (npr. gvozdje)");
        DiseaseSymptom d6 = new DiseaseSymptom(s6, podDisease3);

        Symptom s7 = new Symptom("zutiranje mladog lisca","Nedostatak gvozdja","Primena gvozdjem obogascenog djubriva");
        DiseaseSymptom d7 = new DiseaseSymptom(s7, podpodDisease31);

        Symptom s8 = new Symptom("zutilo izmedju vena lisca","Nedostatak gvozdja","Primena gvozdjem obogascenog djubriva");
        DiseaseSymptom d8 = new DiseaseSymptom(s8, podpodDisease31);

        Symptom s9 = new Symptom("Opste zutiranje lisca","Nedostatak azota","Primena azotom obogascenog djubriva");
        DiseaseSymptom d9 = new DiseaseSymptom(s9, podpodDisease32);

        Symptom s10 = new Symptom("zutiranje lisca sa mrljama","Infekcija patogenom (npr. gljivicom)","Primena fungicida za suzbijanje patogena");
        DiseaseSymptom d10 = new DiseaseSymptom(s10, podpodDisease41);

        diseaseRepository.save(glavnaDisease);
        diseaseRepository.save(podDisease1);
        diseaseRepository.save(podDisease2);
        diseaseRepository.save(podDisease3);
        diseaseRepository.save(podpodDisease31);
        diseaseRepository.save(podpodDisease32);
        diseaseRepository.save(podDisease4);
        diseaseRepository.save(podpodDisease41);
        diseaseRepository.save(glavnaDisease1);
        diseaseRepository.save(podDisease5);
        diseaseRepository.save(podDisease6);
        diseaseRepository.save(podpodDisease61);
        diseaseRepository.save(podpodDisease62);

        subDiseaseRepository.save(subDisease);
        subDiseaseRepository.save(subDisease1);
        subDiseaseRepository.save(subDisease2);
        subDiseaseRepository.save(subDisease3);
        subDiseaseRepository.save(subDisease4);
        subDiseaseRepository.save(subDisease5);
        subDiseaseRepository.save(subDisease6);
        subDiseaseRepository.save(subDisease7);
        subDiseaseRepository.save(subDisease8);
        subDiseaseRepository.save(subDisease9);
        subDiseaseRepository.save(subDisease10);
        subDiseaseRepository.save(subDisease11);
        subDiseaseRepository.save(subDisease12);

        symptomRepository.save(s);
        symptomRepository.save(s1);
        symptomRepository.save(s2);
        symptomRepository.save(s3);
        symptomRepository.save(s4);
        symptomRepository.save(s5);
        symptomRepository.save(s6);
        symptomRepository.save(s7);
        symptomRepository.save(s8);
        symptomRepository.save(s9);
        symptomRepository.save(s10);

        diseaseSymptomRepository.save(d);
        diseaseSymptomRepository.save(d1);
        diseaseSymptomRepository.save(d2);
        diseaseSymptomRepository.save(d3);
        diseaseSymptomRepository.save(d4);
        diseaseSymptomRepository.save(d5);
        diseaseSymptomRepository.save(d6);
        diseaseSymptomRepository.save(d7);
        diseaseSymptomRepository.save(d8);
        diseaseSymptomRepository.save(d9);
        diseaseSymptomRepository.save(d10);
    }

    public ArrayList<String> getSymptoms() {
        ArrayList<String> symptoms = new ArrayList<>();
        symptomRepository.findAll().forEach((s) -> {symptoms.add(s.getSymptom());});
        return symptoms;
    }

    public ArrayList<BackwardGroupedDiseases> diagnose(ArrayList<String> symptoms) {
        KieSession kieSession = kieContainer.newKieSession("backward");
        kieSession.addEventListener(new DebugAgendaEventListener());

//        HashMap<String, ArrayList<Disease>> symptomsPaths = new HashMap<>();
//        kieSession.setGlobal("symptomsPaths", symptomsPaths);
//        kieSession.insert(symptomsPaths);
        insertSubDiseases(kieSession);
        insertDiseaseSymptom(kieSession);
        insertSymptoms(kieSession);


        symptoms.forEach(kieSession::insert);
//        insertTree(kieSession);
        ArrayList<BackwardGroupedDiseases> res = insertTopDiseases(kieSession);


        kieSession.fireAllRules();
//
        return res;
    }

    private ArrayList<BackwardGroupedDiseases> insertTopDiseases(KieSession kieSession) {
        ArrayList<BackwardGroupedDiseases> res = new ArrayList<>();
        diseaseRepository.findDiseaseByTopIsTrue().forEach(disease ->
        {
            Disease dd = new Disease(disease.getDisease());
            BackwardGroupedDiseases b = new BackwardGroupedDiseases(dd);
            kieSession.insert(b);
            res.add(b);
        });
        return res;
    }

    private void insertSubDiseases(KieSession kieSession) {
        for(SubDisease d: subDiseaseRepository.findAll()){
            kieSession.insert(d);
        }
    }

    private void insertDiseaseSymptom(KieSession kieSession) {
        for(DiseaseSymptom d: diseaseSymptomRepository.findAll()){
            kieSession.insert(d);
        }
    }

    private void insertSymptoms(KieSession kieSession) {
        for(Symptom d: symptomRepository.findAll()){
            kieSession.insert(d);
        }
    }
    
    private void insertTree(KieSession kieSession){
        Disease glavnaDisease = new Disease("zutiranje lisca");
        glavnaDisease.setTop(true);
        Disease podDisease1 = new Disease("Nedostatak svetlosti");
        Disease podDisease2 = new Disease("Visak zalivanja");
        Disease podDisease3 = new Disease("Nedostatak hranljivih materija");
        Disease podpodDisease31 = new Disease("Nedostatak gvozdja");
        Disease podpodDisease32 = new Disease("Nedostatak azota");
        Disease podDisease4 = new Disease("Biljna bolest");
        Disease podpodDisease41 = new Disease("Infekcija patogenom (npr. gljivicom)");

        Disease glavnaDisease1 = new Disease("Listna trulez");
        glavnaDisease1.setTop(true);
        Disease podDisease5 = new Disease("Infekcija bakterijama");
        Disease podDisease6 = new Disease("Bolest uzrokovana stetocinama");
        Disease podpodDisease61 = new Disease("Infestacija lisnih usi");
        Disease podpodDisease62 = new Disease("Infestacija grinja");

        SubDisease subDisease = new SubDisease(podDisease1, glavnaDisease);
        SubDisease subDisease1 = new SubDisease(podDisease2, glavnaDisease);
        SubDisease subDisease2 = new SubDisease(podDisease3, glavnaDisease);
        SubDisease subDisease3 = new SubDisease(podpodDisease31, podDisease3);
        SubDisease subDisease4 = new SubDisease(podpodDisease32, podDisease3);
        SubDisease subDisease5 = new SubDisease(podDisease4, glavnaDisease);
        SubDisease subDisease6 = new SubDisease(podpodDisease41, podDisease4);

        SubDisease subDisease7 = new SubDisease(podDisease4, glavnaDisease1);
        SubDisease subDisease8 = new SubDisease(podDisease5, glavnaDisease1);
        SubDisease subDisease9 = new SubDisease(podDisease6, glavnaDisease1);
        SubDisease subDisease10 = new SubDisease(podpodDisease61, podDisease6);
        SubDisease subDisease11 = new SubDisease(podpodDisease62, podDisease6);
        SubDisease subDisease12 = new SubDisease(podDisease3, glavnaDisease1);

        kieSession.insert(subDisease);
        kieSession.insert(subDisease1);
        kieSession.insert(subDisease2);
        kieSession.insert(subDisease3);
        kieSession.insert(subDisease4);
        kieSession.insert(subDisease5);
        kieSession.insert(subDisease6);
        kieSession.insert(subDisease7);
        kieSession.insert(subDisease8);
        kieSession.insert(subDisease9);
        kieSession.insert(subDisease10);
        kieSession.insert(subDisease11);
        kieSession.insert(subDisease12);
        
        Symptom s = new Symptom("tamne mrlje i trulez na liscu","Infekcija patogenom (npr. gljivicom)", "Uklanjanje ostecenog lisca i primena fungicida");
        DiseaseSymptom d = new DiseaseSymptom(s, podpodDisease41);

        Symptom s1 = new Symptom("Vodenaste mrlje na liscu","Infekcija bakterijama", "Uklanjanje ostecenog lisca i primena baktericidnog sredstva");
        DiseaseSymptom d1 = new DiseaseSymptom(s1, podDisease5);

        Symptom s2 = new Symptom("Pojava malih, zelenih insekata na liscu","Infestacija lisnih usi", "Prskanje insekticidom ili prirodni repelenti");
        DiseaseSymptom d2 = new DiseaseSymptom(s2, podpodDisease61);

        Symptom s3 = new Symptom("Pojava sitnih crvenih tackica na liscu","Infestacija grinja", "Prskanje akaricidom i odrzavanje odgovarajuce vlaznosti");
        DiseaseSymptom d3 = new DiseaseSymptom(s3, podpodDisease62);

        Symptom s4 = new Symptom("zutiranje i opadanje lisca","Nedovoljna kolicina svetlosti", "Premestite biljku na osvetljeno mesto");
        DiseaseSymptom d4 = new DiseaseSymptom(s4, podDisease1);

        Symptom s5 = new Symptom("zutiranje i venusce lisca","Prekomerno zalivanje","Smanjite ucestalost zalivanja i proverite drenazu");
        DiseaseSymptom d5 = new DiseaseSymptom(s5, podDisease2);

        Symptom s6 = new Symptom("zutiranje lisca sa tamnim venama","Nedostatak odredjenih hranljivih materija (npr. gvozdje)");
        DiseaseSymptom d6 = new DiseaseSymptom(s6, podDisease3);

        Symptom s7 = new Symptom("zutiranje mladog lisca","Nedostatak gvozdja","Primena gvozdjem obogascenog djubriva");
        DiseaseSymptom d7 = new DiseaseSymptom(s7, podpodDisease31);

        Symptom s8 = new Symptom("zutilo izmedju vena lisca","Nedostatak gvozdja","Primena gvozdjem obogascenog djubriva");
        DiseaseSymptom d8 = new DiseaseSymptom(s8, podpodDisease31);

        Symptom s9 = new Symptom("Opste zutiranje lisca","Nedostatak azota","Primena azotom obogascenog djubriva");
        DiseaseSymptom d9 = new DiseaseSymptom(s9, podpodDisease32);

        Symptom s10 = new Symptom("zutiranje lisca sa mrljama","Infekcija patogenom (npr. gljivicom)","Primena fungicida za suzbijanje patogena");
        DiseaseSymptom d10 = new DiseaseSymptom(s10, podpodDisease41);

        kieSession.insert(d);
        kieSession.insert(d1);
        kieSession.insert(d2);
        kieSession.insert(d3);
        kieSession.insert(d4);
        kieSession.insert(d5);
        kieSession.insert(d6);
        kieSession.insert(d7);
        kieSession.insert(d8);
        kieSession.insert(d9);
        kieSession.insert(d10);

        kieSession.insert(s);
        kieSession.insert(s1);
        kieSession.insert(s2);
        kieSession.insert(s3);
        kieSession.insert(s4);
        kieSession.insert(s5);
        kieSession.insert(s6);
        kieSession.insert(s7);
        kieSession.insert(s8);
        kieSession.insert(s9);
        kieSession.insert(s10);
        
    }
}
