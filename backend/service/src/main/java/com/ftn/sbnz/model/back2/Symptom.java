package com.ftn.sbnz.model.back2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kie.api.definition.type.Position;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "symptoms")
public class Symptom {
    @Position(0)
    private String symptom;
    @Position(1)
    private String cause;
    @Position(2)
    private String treatment;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Symptom(String symptom, String cause) {
        this.symptom = symptom;
        this.cause = cause;
    }

    public Symptom(String symptom, String cause, String treatment) {
        this.symptom = symptom;
        this.cause = cause;
        this.treatment = treatment;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) { return false; }

        Symptom location1 = (Symptom) o;

        if (cause != null ? !cause.equals(location1.cause) : location1.cause != null) { return false; }
        if (treatment != null ? !treatment.equals(location1.treatment) : location1.treatment != null) { return false; }
        if (symptom != null ? !symptom.equals(location1.symptom) : location1.symptom != null) { return false; }

        return true;
    }

}
