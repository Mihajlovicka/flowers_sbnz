package com.ftn.sbnz.service.tests;

import com.ftn.sbnz.model.disease.*;
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
        Plant p1 = new Plant(1L,"Orchid1", 5., CareLevel.EASY,PlantLevel.EASY, e1, d1, m1);

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

    @Test
    public void test1() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession();
//        ksession.addEventListener(new DebugAgendaEventListener());


        // Inserted data
        ksession.insert(new Disease("Truljenje korena", "Orhideja"));
        ksession.insert(new Symptom("Promena boje korena", "Truljenje korena"));
        ksession.insert(new Symptom("Truljenje korena", "Truljenje korena"));
        ksession.insert(new Symptom("Opadanje lisca", "Truljenje korena"));
        ksession.insert(new Cause("Prekomerno zalivanje", "Promena boje korena"));
        ksession.insert(new Cause("Losa drenaza supstrata", "Promena boje korena"));
        ksession.insert(new Cause("Prekomerno zalivanje", "Truljenje korena"));
        ksession.insert(new Cause("Losa drenaza supstrata", "Truljenje korena"));
        ksession.insert(new Cause("Kontaminirani supstrat", "Truljenje korena"));
        ksession.insert(new Treatment("Uklanjanje trulih korena", "Promena boje korena"));
        ksession.insert(new Treatment("Presadjivanje u svez supstrat", "Promena boje korena"));
        ksession.insert(new Treatment("Uklanjanje trulih korena", "Truljenje korena"));
        ksession.insert(new Treatment("Presadjivanje u svez supstrat", "Truljenje korena"));
        ksession.insert(new Treatment("Smanjenje zalivanja", "Truljenje korena"));
        ksession.insert(new Treatment("Primena fungicida", "Truljenje korena"));
        ksession.insert(new Treatment("Poboljsanje cirkulacije vazduha", "Opadanje lisca"));
        ksession.insert(new Treatment("Pravilan rezim zalivanja", "Opadanje lisca"));
        ksession.insert(new Treatment("Hranjenje biljke", "Opadanje lisca"));

        ksession.insert(new Disease("Virus mozaika", "Orhideja"));
        ksession.insert(new Symptom("Promene na liscu", "Virus mozaika"));
        ksession.insert(new Symptom("Promene u boji cveta", "Virus mozaika"));
        ksession.insert(new Cause("Infekcija virusom", "Promene na liscu"));
        ksession.insert(new Cause("Infekcija virusom", "Promene u boji cveta"));
        ksession.insert(new Treatment("Uklanjanje zarazenih delova biljke", "Promene na liscu"));
        ksession.insert(new Treatment("Uklanjanje zarazenih cvetova", "Promene u boji cveta"));


        ksession.insert(new PlantName("Orhideja"));
        ksession.insert("Promena boje korena");
        ksession.insert("Truljenje korena");
        ksession.insert("Opadanje lisca");
        ksession.insert("Promene na liscu");


        long ruleFireCount = 0;
        ruleFireCount = ksession.fireAllRules();
        System.out.println("---" + ruleFireCount);


    }

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

}
