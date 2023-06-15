package com.ftn.sbnz.model.user;

import com.ftn.sbnz.model.plant.Plant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @ManyToOne
    private Plant plant;
    @ManyToOne
    private User user;
    @OneToMany
    private List<PositiveReview> positive = new ArrayList<>();
    @OneToMany
    private List<NegativeReview> negative = new ArrayList<>();

    public void addPositive(PositiveReview positiveReview){
        this.positive.add(positiveReview);
    }
    public void addNegative(NegativeReview positiveReview){
        this.negative.add(positiveReview);
    }

    public Statistic(Plant plant, User user) {
        this.plant = plant;
        this.user = user;
    }
}
