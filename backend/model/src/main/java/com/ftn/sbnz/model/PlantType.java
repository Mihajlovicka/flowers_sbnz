package com.ftn.sbnz.model;

public enum PlantType {
    ANNUAL("Annual"),
    PERENNIAL("Perennial");

    private final String value;

    PlantType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
