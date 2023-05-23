package com.ftn.sbnz.service.tests;

import com.ftn.sbnz.model.*;
import com.ftn.sbnz.util.DebugAgendaEventListener;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


public class RulesTest {

    @Test
    public void testRules() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession();
        ksession.addEventListener(new DebugAgendaEventListener());

        Size s = new Size(2,10,2,10);
        Environment e1 = new Environment(new ArrayList(Arrays.asList(Sunlight.PartialSun)),40,false,0.0,0.0);
        Maintenance m1 = new Maintenance(1,"",WateringNeeds.LOW,"","","",MaintenanceNeeds.LOW,PlantResistanceLevel.MODERATELY_RESISTANT);
        Flower f = new Flower(true,new ArrayList<>(Arrays.asList(Season.SPRING)));
        Description d1 = new Description(new ArrayList(Arrays.asList("red","blue")),s,"",PlantType.ANNUAL,f,new ArrayList<>(Arrays.asList(Season.SPRING)));
        Plant p1 = new Plant("Orchid1",CareLevel.EASY,e1,d1,m1);

        Environment e2 = new Environment(new ArrayList(Arrays.asList(Sunlight.PartialSun)),60,true,0.0,0.0);
        Maintenance m2 = new Maintenance(1,"",WateringNeeds.AVERAGE,"","","",MaintenanceNeeds.LOW,PlantResistanceLevel.HIGH_RESISTANT);
        Description d2 = new Description(new ArrayList(Arrays.asList("red","violet")),s,"",PlantType.PERENNIAL,f,new ArrayList<>(Arrays.asList(Season.SPRING)));
        Plant p2 = new Plant("Orchid2",CareLevel.EASY,e2,d2,m2);

        Environment e3 = new Environment(new ArrayList(Arrays.asList(Sunlight.PartialSun)),40,false,0.0,0.0);
        Maintenance m3 = new Maintenance(1,"",WateringNeeds.HIGH,"","","",MaintenanceNeeds.LOW,PlantResistanceLevel.SENSITIVE);
        Description d3 = new Description(new ArrayList(Arrays.asList("red","blue")),s,"",PlantType.ANNUAL,f,new ArrayList<>(Arrays.asList(Season.SPRING)));
        Plant p3 = new Plant("Orchid3",CareLevel.EASY,e3,d3,m3);

        PlantCareUserForm plantCareUserForm = new PlantCareUserForm(UserLevel.BEGINNER, PlantCareUserForm.Frequency.DAILY, PlantCareUserForm.ConsistencyLevel.INCONSISTENT);
        EnvironmentPreferences environmentPreferences = new EnvironmentPreferences(new ArrayList(Arrays.asList(Sunlight.PartialSun, Sunlight.FullSun)), EnvironmentPreferences.Position.ByDoor, EnvironmentPreferences.Room.Kitchen);
        LookPreferences pref = new LookPreferences(new ArrayList(Arrays.asList("red")), new Size(5,9,1,10),new ArrayList<>(Arrays.asList(Season.SPRING)),PlantType.ANNUAL,f);

        ksession.insert(p1);
        ksession.insert(p2);
        ksession.insert(p3);
        ksession.insert(plantCareUserForm);
        ksession.insert(environmentPreferences);
        ksession.insert(pref);
        long ruleFireCount = ksession.fireAllRules();
        System.out.println(ruleFireCount);
    }

}
