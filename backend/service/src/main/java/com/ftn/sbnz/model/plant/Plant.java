package com.ftn.sbnz.model.plant;

import com.ftn.sbnz.model.enums.CareLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Plant {
    private String name;
    private Double score;
    private CareLevel careLevel;
    private Environment environment;
    private Description description;
    private Maintenance maintenance;
}
