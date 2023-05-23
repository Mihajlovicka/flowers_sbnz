package com.ftn.sbnz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlantCareUserForm {
    private UserLevel userLevel;
//    private int weeklyTimeAvailable;
    private Frequency availabilityFrequency;
    private ConsistencyLevel consistencyLevel;

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

