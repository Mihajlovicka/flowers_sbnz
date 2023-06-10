package com.ftn.sbnz.drools.customFunc;

import com.ftn.sbnz.model.drools.CompMaitPlantO;
import com.ftn.sbnz.model.drools.PlantRec;
import com.ftn.sbnz.model.drools.RecommendationPoints;
import com.ftn.sbnz.model.enums.Color;
import com.ftn.sbnz.model.plant.Plant;
import org.mvel2.util.Make;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CompMaitPlant implements org.kie.api.runtime.rule.AccumulateFunction<CompMaitPlant.CountData>{

    public static class CountData implements Externalizable {
        HashMap<String, Double> points = new HashMap();


        public CountData() {}

        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            points = ( HashMap<String, Double>) in.readObject();
        }

        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(points);
        }

    }
    @Override
    public CountData createContext() {
        return new CountData();
    }

    @Override
    public void init(CountData data) throws Exception {
        data.points = new HashMap<>();
    }

    @Override
    public void accumulate(CountData data, Object o) {
        CompMaitPlantO objects = (CompMaitPlantO) o;
        Plant plant = (Plant) objects.getPlant();
        Plant plantRec = (Plant) objects.getRec();
        double d= 0;
        if(plantRec.getMaintenance().getWateringNeeds().equals(plant.getMaintenance().getWateringNeeds()))
            d+=1;
        if(plantRec.getMaintenance().getMaintenanceNeeds().equals(plant.getMaintenance().getMaintenanceNeeds()))
            d+=1;
        if(plantRec.getMaintenance().getResistant().equals(plant.getMaintenance().getResistant()))
            d+=1;
        for (Color c : plantRec.getDescription().getColor()) {
            if (plant.getDescription().getColor().stream().anyMatch(c1 -> c.name().equals(c1.name()))) {
                d += 1;
            }
        }

        data.points.merge(plantRec.getName(), d/3, Double::sum);
    }


    @Override
    public void reverse(CountData data, Object o) throws Exception {
        CompMaitPlantO objects = (CompMaitPlantO) o;
        Plant plant = (Plant) objects.getPlant();
        Plant plantRec = (Plant) objects.getRec();
        data.points.remove(plant.getName());
    }

    @Override
    public Object getResult(CountData data) throws Exception {
        return data.points.values();

    }

    @Override
    public boolean supportsReverse() {
        return true;
    }

    @Override
    public Class<?> getResultType() {
        return ArrayList.class;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}
