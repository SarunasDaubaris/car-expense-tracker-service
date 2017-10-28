package com.personalgarage.service.main.cars.interfaces.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FuelTypeConst {

    DIESEL((short) 1, "DIESEL"),
    PETROL((short) 2, "PETROL"),
    PETROL_GAS((short) 3, "PETROL/GAS"),
    PETROL_ELECTRICITY((short) 4, "PETROL ELECTRICITY"),
    ELECTRICITY((short) 5, "ELECTRICITY"),
    DIESEL_ELECTRICITY((short) 6, "DIESEL ELECTRICITY"),
    DIESEL_GAS((short) 7, "DIESEL GAS"),
    BIOETHANOL((short) 8, "BIOETHANOL"),
    OTHER((short) 9, "OTHER");

    private final Short id;
    private final String value;

    FuelTypeConst(Short id, String value) {
        this.id = id;
        this.value = value;
    }

    @JsonCreator
    public static FuelTypeConst forId(Short id) {
        for (FuelTypeConst cnst : FuelTypeConst.values()) {
            if (cnst.getId().equals(id)) {
                return cnst;
            }
        }
        throw new IllegalArgumentException("Invalid FuelTypeConst ID: " + id);
    }

    @JsonValue
    public Short getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}