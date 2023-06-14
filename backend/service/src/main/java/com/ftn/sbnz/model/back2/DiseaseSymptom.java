package com.ftn.sbnz.model.back2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kie.api.definition.type.Position;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "diseaseSymptom")
public class DiseaseSymptom {
    @Position(0)
    @ManyToOne
    private Symptom symptom;
    @Position(1)@ManyToOne
    private Disease disease;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public DiseaseSymptom(Symptom symptom, Disease disease) {
        this.symptom = symptom;
        this.disease = disease;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) { return false; }

        DiseaseSymptom location1 = (DiseaseSymptom) o;

        if (disease != null ? !disease.equals(location1.disease) : location1.disease != null) { return false; }
        if (symptom != null ? !symptom.equals(location1.symptom) : location1.symptom != null) { return false; }

        return true;
    }


}
