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
@Entity(name = "user")
public class User {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    @OneToOne
    private PlantCareUserForm plantCareUserForm;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Plant> plants = new ArrayList<>();

    public void addPlant(Plant p){
        this.plants.add(p);
    }

}
