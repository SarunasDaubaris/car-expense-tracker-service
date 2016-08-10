package com.personalgarage.service.enums;

public enum UsersTypesEnum {

    BASIC("1", "Basic"),
    PREMIUM("2", "Premium");

    private String id;
    private String value;

    UsersTypesEnum(String id, String value) {
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