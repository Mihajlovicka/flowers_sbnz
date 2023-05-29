package com.ftn.sbnz.model.disease;

import com.ftn.sbnz.model.enums.SpaceNeed;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kie.api.definition.type.Position;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SpacingGood {
    @Position(0)
    private SpaceNeed space1;
    @Position(1)
    private SpaceNeed space2;
}
