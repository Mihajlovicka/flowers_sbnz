package com.ftn.sbnz.model.drools;

import com.ftn.sbnz.model.plant.Plant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompMaitPlantO {
    private Plant plant;
    private Plant rec;
}
