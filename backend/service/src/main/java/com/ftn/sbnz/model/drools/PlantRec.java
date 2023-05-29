package com.ftn.sbnz.model.drools;

import com.ftn.sbnz.model.enums.PotType;
import com.ftn.sbnz.model.plant.Plant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlantRec {
    private Plant plant;
    private Double points;
    private Double fit;
    private Boolean compatible;
    private String potSize;
    private ArrayList<PotType> potTypes = new ArrayList<>();

    public PlantRec(Plant plant, Double points) {
        this.plant = plant;
        this.points = points;
        this.fit = 0.0;
        this.compatible = false;
        this.potSize = "";
    }
}
