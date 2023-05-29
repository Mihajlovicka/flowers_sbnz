package com.ftn.sbnz.model.enums;

public enum MaintenanceNeeds {
    LOW("Low"),
    AVERAGE("Average"),
    HIGH("High");

    private final String value;

    MaintenanceNeeds(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
