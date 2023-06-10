package com.ftn.sbnz.model.plant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class Size {
    private double widthMin;
    private double widthMax;
    private double heightMin;
    private double heightMax;

}
