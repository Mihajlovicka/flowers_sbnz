package com.ftn.sbnz.model.enums;

public enum PotType {
    TERRACOTTA("Terracotta"),
    PLASTIC("Plastic"),
    CERAMIC("Ceramic");

    private final String value;

    PotType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}



