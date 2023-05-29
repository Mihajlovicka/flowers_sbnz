package com.ftn.sbnz.model.plant;

import com.ftn.sbnz.model.enums.NutrientType;
import com.ftn.sbnz.model.enums.SpaceNeed;
import com.ftn.sbnz.model.enums.Sunlight;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Environment {
    private ArrayList<Sunlight> sunlight = new ArrayList<>();
    private double humidity; //percents
    private boolean airCirculationSensitivity;
    private double temperatureMax;
    private double temperatureMin;
    private SpaceNeed spaceNeed;
    private ArrayList<NutrientType> nutrientType = new ArrayList<>();
//    private SoilType soilType;
}