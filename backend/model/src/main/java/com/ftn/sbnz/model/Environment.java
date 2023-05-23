package com.ftn.sbnz.model;

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
//    private SoilType soilType;
}
