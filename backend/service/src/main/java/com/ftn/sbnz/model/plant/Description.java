package com.ftn.sbnz.model.plant;

import com.ftn.sbnz.model.enums.Color;
import com.ftn.sbnz.model.enums.PlantType;
import com.ftn.sbnz.model.enums.Season;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class Description {
    private ArrayList<Color> color = new ArrayList<>();
    @Embedded
    private Size averagesSize;
//    private String shape;
    private String picture;
    //brzina rasta
    private PlantType plantType;
    @Embedded
    private Flower flower;
    private ArrayList<Season> seasons = new ArrayList<>();
}
