package com.ftn.sbnz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LookPreferences {
    private ArrayList<String> color = new ArrayList<>();
    private Size size;
    private ArrayList<Season> seasons = new ArrayList<>();
    private PlantType plantType;
    private Flower flower;

}
