package com.ftn.sbnz.model.enums;

public enum UserLevel {
    BEGINNER(0),
    INTERMEDIATE(1),
    ADVANCED(2),
    EXPERT(3);
    private int value;

    UserLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
