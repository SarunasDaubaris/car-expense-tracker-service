package com.personalgarage.service.api.domain.users.data.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserTypeConst {

    BASIC("1", "BASIC"),
    PREMIUM("2", "PREMIUM");

    private final String id;
    private final String value;

    UserTypeConst(String id, String value) {
        this.id = id;
        this.value = value;
    }

    @JsonCreator
    public static UserTypeConst forId(String id) {
        for(UserTypeConst cnst : UserTypeConst.values()) {
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