package com.ftn.sbnz.service.tests;

//import com.ftn.sbnz.model.disease.*;
import com.ftn.sbnz.model.back2.Disease;
import com.ftn.sbnz.model.back2.DiseaseSymptom;
import com.ftn.sbnz.model.back2.SubDisease;
import com.ftn.sbnz.model.back2.Symptom;
import com.ftn.sbnz.model.disease.SpacingBad;
import com.ftn.sbnz.model.disease.SpacingGood;
import com.ftn.sbnz.model.drools.BackwardGroupedDiseases;
import com.ftn.sbnz.model.drools.PlantRec;
import com.ftn.sbnz.model.drools.UserLevelInsert;
import com.ftn.sbnz.model.drools.UserPlant;
import com.ftn.sbnz.model.enums.*;
import com.ftn.sbnz.model.plant.*;
import com.ftn.sbnz.model.user.EnvironmentPreferences;
import com.ftn.sbnz.model.user.LookPreferences;
import com.ftn.sbnz.model.user.PlantCareUserForm;
import com.ftn.sbnz.util.DebugAgendaEventListener;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class RulesTest {

    @Test
    public void testRules() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession("forward");
        ksession.addEventListener(new DebugAgendaEventListener());

        ksession.insert(new SpacingGood(SpaceNeed.COMPACT, SpaceNeed.VERTICAL));
        ksession.insert(new SpacingGood(SpaceNeed.COMPACT, SpaceNeed.COMPACT));
        ksession.insert(new SpacingGood(SpaceNeed.MODERATE, SpaceNeed.VERTICAL));
        ksession.insert(new SpacingGood(SpaceNeed.MODERATE, SpaceNeed.MODERATE));
        ksession.insert(new SpacingGood(SpaceNeed.VERTICAL, SpaceNeed.VERTICAL));
        ksession.insert(new SpacingGood(SpaceNeed.DENSE, SpaceNeed.UNDERGROUND));
        ksession.insert(new SpacingGood(SpaceNeed.MODERATE, SpaceNeed.AGGRESSIVE));
        ksession.insert(new SpacingBad(SpaceNeed.COMPACT, SpaceNeed.AGGRESSIVE));
        ksession.insert(new SpacingBad(SpaceNeed.DENSE, SpaceNeed.MODERATE));
        ksession.insert(new SpacingBad(SpaceNeed.AGGRESSIVE, SpaceNeed.VERTICAL));
        ksession.insert(new SpacingBad(SpaceNeed.DENSE, SpaceNeed.COMPACT));
        ksession.insert(new SpacingBad(SpaceNeed.DENSE, SpaceNeed.AGGRESSIVE));
        ksession.insert(new SpacingBad(SpaceNeed.DENSE, SpaceNeed.VERTICAL));
        ksession.insert(new SpacingBad(SpaceNeed.DENSE, SpaceNeed.DENSE));
        ksession.insert(new SpacingBad(SpaceNeed.AGGRESSIVE, SpaceNeed.AGGRESSIVE));

        Size s = new Size(2, 10, 2, 10);
        Environment e1 = new Environment(new ArrayList(Arrays.asList(Sunlight.PartialSun)), 40, false, 0.0, 0.0, SpaceNeed.VERTICAL, new ArrayList(Arrays.asList(NutrientType.CALCIUM)));
        Maintenance m1 = new Maintenance(1, "", WateringNeeds.AVERAGE, "", "", "", MaintenanceNeeds.LOW, PlantResistanceLevel.MODERATELY_RESISTANT);
        Flower f = new Flower(true, new ArrayList<>(Arrays.asList(Season.SPRING)));
        Description d1 = new Description(new ArrayList(Arrays.asList("red", "blue")), s, "", PlantType.ANNUAL, f, new ArrayList<>(Arrays.asList(Season.SPRING)));
        Plant p1 = new Plant(1L, "Orchid1", 5., CareLevel.EASY, PlantLevel.EASY, e1, d1, m1);

//        Environment e2 = new Environment(new ArrayList(Arrays.asList(Sunlight.PartialSun)), 60, true, 0.0, 0.0, SpaceNeed.COMPACT, new ArrayList(Arrays.asList(NutrientType.BORON)));
//        Maintenance m2 = new Maintenance(1, "", WateringNeeds.AVERAGE, "", "", "", MaintenanceNeeds.LOW, PlantResistanceLevel.HIGH_RESISTANT);
//        Description d2 = new Description(new ArrayList(Arrays.asList("red", "violet")), s, "", PlantType.PERENNIAL, f, new ArrayList<>(Arrays.asList(Season.SPRING)));
//        Plant p2 = new Plant("Orchid2", 5., CareLevel.EASY, e2, d2, m2);
//
//        Environment e3 = new Environment(new ArrayList(Arrays.asList(Sunlight.PartialSun)), 40, false, 0.0, 0.0, SpaceNeed.COMPACT, new ArrayList(Arrays.asList(NutrientType.CALCIUM)));
//        Maintenance m3 = new Maintenance(1, "", WateringNeeds.HIGH, "", "", "", MaintenanceNeeds.LOW, PlantResistanceLevel.SENSITIVE);
//        Description d3 = new Description(new ArrayList(Arrays.asList("red", "blue")), s, "", PlantType.ANNUAL, f, new ArrayList<>(Arrays.asList(Season.SPRING)));
//        Plant p3 = new Plant("Orchid3", 5., CareLevel.EASY, e2, d2, m2);
////
        PlantCareUserForm plantCareUserForm = new PlantCareUserForm(UserLevel.BEGINNER, PlantCareUserForm.Frequency.DAILY, PlantCareUserForm.ConsistencyLevel.FAIRLY_CONSISTENT);
        EnvironmentPreferences environmentPreferences = new EnvironmentPreferences(new ArrayList(Arrays.asList(Sunlight.PartialSun)), EnvironmentPreferences.Position.ByDoor, EnvironmentPreferences.Room.Kitchen);
        LookPreferences pref = new LookPreferences(new ArrayList(Arrays.asList("red")), new Size(5, 9, 1, 10), new ArrayList<>(Arrays.asList(Season.SPRING)), PlantType.ANNUAL, f);

        HashMap<Long, PlantRec> recommendedPlants = new HashMap<>();
//        ArrayList<UserPlant> userPlants = new ArrayList<>();
//        userPlants.add(new UserPlant("Orchid1"));
//        userPlants.add(new UserPlant("Orchid2"));

        ksession.insert(new UserLevelInsert(UserLevel.BEGINNER));
        ksession.insert(p1);
//        ksession.insert(p2);
//        ksession.insert(p3);
        ksession.insert(plantCareUserForm);
        ksession.insert(environmentPreferences);
        ksession.insert(pref);
        ksession.setGlobal("recommendedPlants", recommendedPlants);
        ksession.insert(recommendedPlants);
//        userPlants.forEach(el -> ksession.insert(el));
        long ruleFireCount = ksession.fireAllRules();
        System.out.println(ruleFireCount);
        for (Long k : recommendedPlants.keySet()) {
            System.out.println("k: " + k + " v: " + recommendedPlants.get(k).getPoints());
        }
    }

//    @Test
//    public void test1() {
//        KieServices ks = KieServices.Factory.get();
//        KieContainer kc = ks.newKieClasspathContainer();
//        KieSession ksession = kc.newKieSession();
////        ksession.addEventListener(new DebugAgendaEventListener());
//
//
//        // Inserted data
//        ksession.insert(new Disease("Truljenje korena", "Orhideja"));
//        ksession.insert(new Symptom("Promena boje korena", "Truljenje korena"));
//        ksession.insert(new Symptom("Truljenje korena", "Truljenje korena"));
//        ksession.insert(new Symptom("Opadanje lisca", "Truljenje korena"));
//        ksession.insert(new Cause("Prekomerno zalivanje", "Promena boje korena"));
//        ksession.insert(new Cause("Losa drenaza supstrata", "Promena boje korena"));
//        ksession.insert(new Cause("Prekomerno zalivanje", "Truljenje korena"));
//        ksession.insert(new Cause("Losa drenaza supstrata", "Truljenje korena"));
//        ksession.insert(new Cause("Kontaminirani supstrat", "Truljenje korena"));
//        ksession.insert(new Treatment("Uklanjanje trulih korena", "Promena boje korena"));
//        ksession.insert(new Treatment("Presadjivanje u svez supstrat", "Promena boje korena"));
//        ksession.insert(new Treatment("Uklanjanje trulih korena", "Truljenje korena"));
//        ksession.insert(new Treatment("Presadjivanje u svez supstrat", "Truljenje korena"));
//        ksession.insert(new Treatment("Smanjenje zalivanja", "Truljenje korena"));
//        ksession.insert(new Treatment("Primena fungicida", "Truljenje korena"));
//        ksession.insert(new Treatment("Poboljsanje cirkulacije vazduha", "Opadanje lisca"));
//        ksession.insert(new Treatment("Pravilan rezim zalivanja", "Opadanje lisca"));
//        ksession.insert(new Treatment("Hranjenje biljke", "Opadanje lisca"));
//
//        ksession.insert(new Disease("Virus mozaika", "Orhideja"));
//        ksession.insert(new Symptom("Promene na liscu", "Virus mozaika"));
//        ksession.insert(new Symptom("Promene u boji cveta", "Virus mozaika"));
//        ksession.insert(new Cause("Infekcija virusom", "Promene na liscu"));
//        ksession.insert(new Cause("Infekcija virusom", "Promene u boji cveta"));
//        ksession.insert(new Treatment("Uklanjanje zarazenih delova biljke", "Promene na liscu"));
//        ksession.insert(new Treatment("Uklanjanje zarazenih cvetova", "Promene u boji cveta"));
//
//
//        ksession.insert(new PlantName("Orhideja"));
//        ksession.insert("Promena boje korena");
//        ksession.insert("Truljenje korena");
//        ksession.insert("Opadanje lisca");
//        ksession.insert("Promene na liscu");
//
//
//        long ruleFireCount = 0;
//        ruleFireCount = ksession.fireAllRules();
//        System.out.println("---" + ruleFireCount);
//
//
//    }

    @Test
    public void testLevel() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession("level");
        ksession.addEventListener(new DebugAgendaEventListener());

        Size s = new Size(2, 10, 2, 10);
        Environment e1 = new Environment(new ArrayList(Arrays.asList(Sunlight.PartialSun)), 40, false, 0.0, 0.0, SpaceNeed.VERTICAL, new ArrayList(Arrays.asList(NutrientType.CALCIUM)));
        Maintenance m1 = new Maintenance(1, "", WateringNeeds.LOW, "", "", "", MaintenanceNeeds.LOW, PlantResistanceLevel.HIGH_RESISTANT);
        Flower f = new Flower(true, new ArrayList<>(Arrays.asList(Season.SPRING)));
        Description d1 = new Description(new ArrayList(Arrays.asList("red", "blue")), s, "", PlantType.ANNUAL, f, new ArrayList<>(Arrays.asList(Season.SPRING)));
        Plant p1 = new Plant("Orchid1", 5., CareLevel.EASY, e1, d1, m1);

        ksession.insert(p1);
        long ruleFireCount = ksession.fireAllRules();
        System.out.println(ruleFireCount);
    }


    @Test
    public void backward2() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession("backward");
//        ksession.addEventListener(new DebugAgendaEventListener());

        Disease glavnaDisease = new Disease("zutiranje lisca",1L);
        glavnaDisease.setTop(true);
        Disease podDisease1 = new Disease("Nedostatak svetlosti",2L);
        Disease podDisease2 = new Disease("Visak zalivanja",3L);
        Disease podDisease3 = new Disease("Nedostatak hranljivih materija",4L);
        Disease podpodDisease31 = new Disease("Nedostatak gvozdja",5L);
        Disease podpodDisease32 = new Disease("Nedostatak azota",6L);
        Disease podDisease4 = new Disease("Biljna bolest",7l);
        Disease podpodDisease41 = new Disease("Infekcija patogenom (npr. gljivicom)",8l);
//
//        ksession.insert(podDisease4);
        SubDisease subDisease = new SubDisease(podDisease1, glavnaDisease,1l);
        SubDisease subDisease1 = new SubDisease(podDisease2, glavnaDisease,2l);
        SubDisease subDisease2 = new SubDisease(podDisease3, glavnaDisease,3l);
        SubDisease subDisease3 = new SubDisease(podpodDisease31, podDisease3,4l);
        SubDisease subDisease4 = new SubDisease(podpodDisease32, podDisease3,5l);
        SubDisease subDisease5 = new SubDisease(podDisease4, glavnaDisease,6l);
        SubDisease subDisease6 = new SubDisease(podpodDisease41, podDisease4,7l);
//        SubDisease subDisease5 = new SubDisease(podDisease4, podDisease3);

        ksession.insert(subDisease);
        ksession.insert(subDisease1);
        ksession.insert(subDisease2);
        ksession.insert(subDisease3);
        ksession.insert(subDisease4);
        ksession.insert(subDisease5);
        ksession.insert(subDisease6);

        Disease glavnaDisease1 = new Disease("Listna trulez",9l);
        //podpodDisease41
         glavnaDisease1.setTop(true);
        Disease podDisease5 = new Disease("Infekcija bakterijama",10l);
        Disease podDisease6 = new Disease("Bolest uzrokovana stetocinama",11l);
        Disease podpodDisease61 = new Disease("Infestacija lisnih usi",12l);
        Disease podpodDisease62 = new Disease("Infestacija grinja",13l);

        SubDisease subDisease7 = new SubDisease(podDisease4, glavnaDisease1,8l);
        SubDisease subDisease8 = new SubDisease(podDisease5, glavnaDisease1,9l);
        SubDisease subDisease9 = new SubDisease(podDisease6, glavnaDisease1,10l);
        SubDisease subDisease10 = new SubDisease(podpodDisease61, podDisease6,11l);
        SubDisease subDisease11 = new SubDisease(podpodDisease62, podDisease6,12l);
        SubDisease subDisease12 = new SubDisease(podDisease3, glavnaDisease1,13l);

        Symptom s6 = new Symptom("tamne mrlje i trulez na liscu","Infekcija patogenom (npr. gljivicom)", "Uklanjanje ostecenog lisca i primena fungicida",1l);
        ksession.insert(new DiseaseSymptom(s6, podpodDisease41,1l));

        Symptom s7 = new Symptom("Vodenaste mrlje na liscu","Infekcija bakterijama", "Uklanjanje ostecenog lisca i primena baktericidnog sredstva",2l);
        ksession.insert(new DiseaseSymptom(s7, podDisease5,2l));

        Symptom s8 = new Symptom("Pojava malih, zelenih insekata na liscu","Infestacija lisnih usi", "Prskanje insekticidom ili prirodni repelenti",3l);
        ksession.insert(new DiseaseSymptom(s8, podpodDisease61,3l));

        Symptom s9 = new Symptom("Pojava sitnih crvenih tackica na liscu","Infestacija grinja", "Prskanje akaricidom i odrzavanje odgovarajuce vlaznosti",4l);
        ksession.insert(new DiseaseSymptom(s9, podpodDisease62,4l));


        ksession.insert(subDisease7);
        ksession.insert(subDisease8);
        ksession.insert(subDisease9);
        ksession.insert(subDisease10);
        ksession.insert(subDisease11);
        ksession.insert(subDisease12);

        Symptom s = new Symptom("zutiranje i opadanje lisca","Nedovoljna kolicina svetlosti", "Premestite biljku na osvetljeno mesto",5l);
        ksession.insert(new DiseaseSymptom(s, podDisease1,5l));

        Symptom s1 = new Symptom("zutiranje i venusce lisca","Prekomerno zalivanje","Smanjite ucestalost zalivanja i proverite drenazu",6l);
        ksession.insert(new DiseaseSymptom(s1, podDisease2,6l));

        Symptom s2 = new Symptom("zutiranje lisca sa tamnim venama","Nedostatak odredjenih hranljivih materija (npr. gvozdje)","",7l);
        ksession.insert(new DiseaseSymptom(s2, podDisease3,7l));

        Symptom s3 = new Symptom("zutiranje mladog lisca","Nedostatak gvozdja","Primena gvozdjem obogascenog djubriva",8l);
        ksession.insert(new DiseaseSymptom(s3, podpodDisease31,8l));

        Symptom s10 = new Symptom("zutilo izmedju vena lisca","Nedostatak gvozdja","Primena gvozdjem obogascenog djubriva",9l);
        ksession.insert(new DiseaseSymptom(s10, podpodDisease31,9l));

        Symptom s4 = new Symptom("Opste zutiranje lisca","Nedostatak azota","Primena azotom obogascenog djubriva",10l);
        ksession.insert(new DiseaseSymptom(s4, podpodDisease32,10l));

        Symptom s5 = new Symptom("zutiranje lisca sa mrljama","Infekcija patogenom (npr. gljivicom)","Primena fungicida za suzbijanje patogena",11l);
        ksession.insert(new DiseaseSymptom(s5, podpodDisease41,11l));

        ksession.insert(s);
        ksession.insert(s1);
        ksession.insert(s2);
        ksession.insert(s3);
        ksession.insert(s4);
        ksession.insert(s5);
        ksession.insert(s6);
        ksession.insert(s7);
        ksession.insert(s8);
        ksession.insert(s9);
        ksession.insert(s10);

//        HashMap<String, ArrayList<Disease>> symptomsPaths = new HashMap<>();
//        ksession.setGlobal("symptomsPaths", symptomsPaths);
//        ksession.insert(symptomsPaths);

//        ksession.insert("zutiranje mladog lisca");
//        ksession.insert("zutiranje lisca sa mrljama");
//        ksession.insert("tamne mrlje i trulez na liscu");
        ksession.insert("Vodenaste mrlje na liscu");

        BackwardGroupedDiseases group = new BackwardGroupedDiseases(glavnaDisease);
        BackwardGroupedDiseases group1 = new BackwardGroupedDiseases(glavnaDisease1);
        ksession.insert(group);
        ksession.insert(group1);

        long ruleFireCount = 0;
        ruleFireCount = ksession.fireAllRules();
        System.out.println("---" + ruleFireCount);


    }


}
