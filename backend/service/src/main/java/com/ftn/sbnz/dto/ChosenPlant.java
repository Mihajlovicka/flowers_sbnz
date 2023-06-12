package com.ftn.sbnz.dto;

import com.ftn.sbnz.model.plant.Plant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChosenPlant {
    private Plant plant;
    private String user;
}
