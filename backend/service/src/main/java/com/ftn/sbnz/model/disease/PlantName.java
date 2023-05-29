package com.ftn.sbnz.model.disease;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kie.api.definition.type.Position;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlantName {
    @Position(0)
    private String name;
}
