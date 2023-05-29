package com.ftn.sbnz.model.disease;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kie.api.definition.type.Position;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Symptom {
    @Position(0)
    private String symptom;
    @Position(1)
    private String disease;
}
