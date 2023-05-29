package com.ftn.sbnz.model.enums;

public enum SpaceNeed {
    UNDERGROUND("Under ground"),
    COMPACT("Compact"),
    MODERATE("Moderate spread"),
    AGGRESSIVE("Aggressive spread"),
    VERTICAL("Vertical"),
    DENSE("Dense");

    private final String value;

    SpaceNeed(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
