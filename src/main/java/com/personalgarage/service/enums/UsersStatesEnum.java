package com.personalgarage.service.enums;

public enum UsersStatesEnum {

    NEW("1", "New"),
    ACTIVE("2", "Active"),
    BLOCKED("3", "Blocked"),
    DELETED("4", "Deleted");

    private String id;
    private String value;

    UsersStatesEnum(String id, String value) {
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