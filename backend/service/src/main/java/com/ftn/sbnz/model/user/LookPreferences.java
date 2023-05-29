package com.ftn.sbnz.model.user;

import com.ftn.sbnz.model.enums.PlantType;
import com.ftn.sbnz.model.enums.Season;
import com.ftn.sbnz.model.plant.Flower;
import com.ftn.sbnz.model.plant.Size;
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
