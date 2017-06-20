package com.personalgarage.service.api.domain.users.data.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserStateConst {

    NEW("1", "NEW"),
    ACTIVE("2", "ACTIVE"),
    BLOCKED("3", "BLOCKED"),
    DELETED("4", "DELETED");

    private final String id;
    private final String value;

    UserStateConst(String id, String value) {
        this.id = id;
        this.value = value;
    }

    @JsonCreator
    public static UserStateConst forId(String id) {
        for(UserStateConst cnst : UserStateConst.values()) {
            if(cnst.getId().equals(id)) {
                return cnst;
            }
        }
        throw new IllegalArgumentException("Invalid UsersStatesConst ID: " + id);
    }

    @JsonValue
    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}