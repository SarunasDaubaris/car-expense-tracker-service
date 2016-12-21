package com.personalgarage.service.api.domain.cars.data.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FuelTypesConst {

    DIESEL("1", "DIESEL"),
    PETROL("2", "PETROL"),
    PETROL_GAS("3", "PETROL/GAS"),
    PETROL_ELECTRICITY("4", "PETROL ELECTRICITY"),
    ELECTRICITY("5", "ELECTRICITY"),
    DIESEL_ELECTRICITY("6", "DIESEL ELECTRICITY"),
    DIESEL_GAS("7", "DIESEL GAS"),
    BIOETHANOL("8", "BIOETHANOL"),
    OTHER("9", "OTHER");

    private final String id;
    private final String value;

    FuelTypesConst(String id, String value) {
        this.id = id;
        this.value = value;
    }

    @JsonCreator
    public static FuelTypesConst forId(String id) {
        for(FuelTypesConst cnst : FuelTypesConst.values()) {
            if(cnst.getId().equals(id)) {
                return cnst;
            }
        }
        throw new IllegalArgumentException("Invalid FuelTypesConst ID: " + id);
    }

    @JsonValue
    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}