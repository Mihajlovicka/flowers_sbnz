package com.ftn.sbnz.model.plant;

import com.ftn.sbnz.model.enums.CareLevel;
import com.ftn.sbnz.model.enums.PlantLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "plants")
public class Plant {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Double score;
    private CareLevel careLevel;
    private PlantLevel plantLevel;
    @Embedded
    private Environment environment;
    @Embedded
    private Description description;
    @Embedded
    private Maintenance maintenance;

    public Plant(String name, Double score, CareLevel careLevel, Environment environment, Description description, Maintenance maintenance) {
        this.name = name;
        this.score = score;
        this.careLevel = careLevel;
        this.environment = environment;
        this.description = description;
        this.maintenance = maintenance;
    }
}
