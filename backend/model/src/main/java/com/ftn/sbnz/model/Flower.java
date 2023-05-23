package com.ftn.sbnz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Flower {
    private boolean hasFlowers;
    private ArrayList<Season> floweringSeason = new ArrayList<>();
}
