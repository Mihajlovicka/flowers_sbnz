package com.ftn.sbnz.model;

public enum PlantResistanceLevel {
    HIGH_RESISTANT("Highly Resistant"),
    MODERATELY_RESISTANT("Moderately Resistant"),
    SENSITIVE("Sensitive");

    private final String level;

    PlantResistanceLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}
