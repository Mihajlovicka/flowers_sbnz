package com.ftn.sbnz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Size {
    private double widthMin;
    private double widthMax;
    private double heightMin;
    private double heightMax;

}
