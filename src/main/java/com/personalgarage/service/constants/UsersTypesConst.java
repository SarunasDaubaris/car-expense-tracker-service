package com.personalgarage.service.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UsersTypesConst {

    BASIC("1", "BASIC"),
    PREMIUM("2", "PREMIUM");

    private final String id;
    private final String value;

    UsersTypesConst(String id, String value) {
        this.id = id;
        this.value = value;
    }

    @JsonCreator
    public static UsersTypesConst forId(String id) {
        for(UsersTypesConst cnst : UsersTypesConst.values()) {
            if(cnst.getId().equals(id)) {
                return cnst;
            }
        }
        throw new IllegalArgumentException("Invalid UsersTypesConst ID: " + id);
    }

    @JsonValue
    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}