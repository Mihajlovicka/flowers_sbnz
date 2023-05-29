package com.ftn.sbnz.model.enums;

public enum Sunlight {
    FullSun("Full Sun"),
    PartialSun("Partial Sun"),
    Shade("Shade");

    private final String value;

    Sunlight(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
