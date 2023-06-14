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
@Entity(name = "disease")
public class Disease {
    @Position(0)
    private String disease;

    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean top = false;

    public Disease(String disease) {
        this.disease = disease;
    }

    public Disease(String disease, Long id) {
        this.disease = disease;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) { return false; }

        Disease location1 = (Disease) o;

        if (disease != null ? !disease.equals(location1.disease) : location1.disease != null) { return false; }

        return true;
    }
}
