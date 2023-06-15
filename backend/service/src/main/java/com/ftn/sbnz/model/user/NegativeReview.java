package com.ftn.sbnz.model.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ftn.sbnz.model.back2.Symptom;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class NegativeReview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date date = new Date();
    @ManyToOne
    private Symptom symptom;
    private boolean handled = false;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date dateHandled;

    public NegativeReview(Symptom symptom) {
        this.symptom = symptom;
    }
}
