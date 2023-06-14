package com.ftn.sbnz.model.back2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kie.api.definition.type.Position;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "subDisease")
public class SubDisease {
    @Position(0)
    @ManyToOne
    private Disease subDisease;
    @Position(1)
    @ManyToOne
    private Disease disease;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public SubDisease(Disease subDisease, Disease disease) {
        this.subDisease = subDisease;
        this.disease = disease;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) { return false; }

        SubDisease location1 = (SubDisease) o;

        if (disease != null ? !disease.equals(location1.disease) : location1.disease != null) { return false; }
        if (subDisease != null ? !subDisease.equals(location1.subDisease) : location1.subDisease != null) { return false; }

        return true;
    }


}
