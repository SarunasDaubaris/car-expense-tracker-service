package com.personalgarage.service.enums;

public enum FuelTypesEnum {

    DIESEL("1", "Diesel"),
    PETROL("2", "Petrol"),
    PETROL_GAS("3", "Petrol/Gas"),
    PETROL_ELECTRICITY("4", "Petrol/Electricity"),
    ELECTRICITY("5", "Electricity"),
    DIESEL_ELECTRICITY("6", "Diesel/Electricity"),
    DIESEL_GAS("7", "Diesel/Gas"),
    BIOETHANOL("8", "Bioethanol"),
    OTHER("9", "Other");

    private String id;
    private String value;

    FuelTypesEnum(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}