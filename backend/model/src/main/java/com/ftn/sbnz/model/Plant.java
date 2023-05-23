package com.ftn.sbnz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Plant {
    private String name;
    private CareLevel careLevel;
    private Environment environment;
    private Description description;
    private Maintenance maintenance;
}
