package com.ftn.sbnz.model.user;

import com.ftn.sbnz.model.enums.UserLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name="plantUserForm")
public class PlantCareUserForm {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UserLevel userLevel;
    private Frequency availabilityFrequency;
    private ConsistencyLevel consistencyLevel;

    public PlantCareUserForm(UserLevel userLevel, Frequency availabilityFrequency, ConsistencyLevel consistencyLevel) {
        this.userLevel = userLevel;
        this.availabilityFrequency = availabilityFrequency;
        this.consistencyLevel = consistencyLevel;
    }

    public enum Frequency {
        DAILY,
        EVERY_OTHER_DAY,
        TWICE_A_WEEK,
        ONCE_A_WEEK
    }

    public enum ConsistencyLevel {
        VERY_CONSISTENT,
        FAIRLY_CONSISTENT,
        INCONSISTENT
    }

}

