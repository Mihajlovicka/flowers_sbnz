package com.ftn.sbnz.model;

public enum Season {
    SPRING("Spring"),
    SUMMER("Summer"),
    FALL("Fall"),
    WINTER("Winter");

    private final String value;

    Season(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
