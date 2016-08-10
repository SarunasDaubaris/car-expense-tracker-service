package com.personalgarage.service.enums;

public enum TransactionsTypesEnum {

    FUEL("1", "Fuel"),
    INSURANCE("2", "Insurance"),
    REGULAR_MAINTENANCE("3", "Regular Maintenance"),
    DEFECT_REPAIRS("4", "Defect Repairs"),
    AFTERMARKET_IMPROVEMENTS("5", "Aftermarket Improvements"),
    OTHER("6", "Other");

    private String id;
    private String value;

    TransactionsTypesEnum(String id, String value) {
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