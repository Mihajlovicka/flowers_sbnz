package com.ftn.sbnz.model;

public enum WateringNeeds {
    LOW("Low"),
    AVERAGE("Average"),
    HIGH("High");

    private final String value;

    WateringNeeds(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
