package com.ftn.sbnz.model.drools;

import com.ftn.sbnz.model.back2.Disease;
import com.ftn.sbnz.model.back2.Symptom;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BackwardGroupedDiseases {
    private Disease disease;
    private ArrayList<Symptom> symptoms = new ArrayList<>();

    private boolean max = false;

    public BackwardGroupedDiseases(Disease disease) {
        this.disease = disease;
    }


}
