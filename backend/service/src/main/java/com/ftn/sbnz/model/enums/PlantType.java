package com.ftn.sbnz.model.enums;

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
