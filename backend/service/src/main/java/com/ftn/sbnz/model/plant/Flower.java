package com.ftn.sbnz.model.plant;

import com.ftn.sbnz.model.enums.Season;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class Flower {
    private boolean hasFlowers;
    private ArrayList<Season> floweringSeason = new ArrayList<>();
}
