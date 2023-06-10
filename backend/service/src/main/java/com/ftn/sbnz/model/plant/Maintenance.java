package com.ftn.sbnz.model.plant;

import com.ftn.sbnz.model.enums.MaintenanceNeeds;
import com.ftn.sbnz.model.enums.PlantResistanceLevel;
import com.ftn.sbnz.model.enums.WateringNeeds;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class Maintenance {
    private int wateringFrequency;//per week
    private String wateringAmount;
    private WateringNeeds wateringNeeds;
    private String pruning;
    private String fertilization;
    private String plantTransplant;
    private MaintenanceNeeds maintenanceNeeds;
    private PlantResistanceLevel resistant;
}

