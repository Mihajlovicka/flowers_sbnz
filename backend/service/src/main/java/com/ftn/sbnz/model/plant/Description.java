package com.ftn.sbnz.model.plant;

import com.ftn.sbnz.model.enums.PlantType;
import com.ftn.sbnz.model.enums.Season;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Description {
    private ArrayList<String> color = new ArrayList<>();
    private Size averagesSize;
//    private String shape;
    private String picture;
    //brzina rasta
    private PlantType plantType;
    private Flower flower;
    private ArrayList<Season> seasons = new ArrayList<>();
}
