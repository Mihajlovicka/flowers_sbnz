package com.ftn.sbnz.drools.customFunc;

import com.ftn.sbnz.model.drools.RecommendationPoints;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.HashMap;

public class SumPointsForPlant implements org.kie.api.runtime.rule.AccumulateFunction<SumPointsForPlant.SumData>{

    public static class SumData implements Externalizable {
        HashMap<Long, Double> points = new HashMap();


        public SumData() {}

        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            points = (HashMap<Long, Double>) in.readObject();
        }

        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(points);
        }

    }
    @Override
    public SumData createContext() {
        return new SumData();
    }

    @Override
    public void init(SumData sumData) throws Exception {
        sumData.points = new HashMap<>();
    }

    @Override
    public void accumulate(SumData sumData, Object recommendPoint) {
        Double b = ((RecommendationPoints)recommendPoint).getPoints() * ((RecommendationPoints)recommendPoint).getPlant().getScore();
        sumData.points.merge(((RecommendationPoints) recommendPoint).getPlant().getId(), b, Double::sum);
    }

    @Override
    public void reverse(SumData sumData, Object recommendPoint) throws Exception {
        sumData.points.remove(((RecommendationPoints) recommendPoint).getPlant().getId());
    }

    @Override
    public Object getResult(SumData sumData) throws Exception {
        return sumData.points;

    }

    @Override
    public boolean supportsReverse() {
        return true;
    }

    @Override
    public Class<?> getResultType() {
        return HashMap.class;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}
