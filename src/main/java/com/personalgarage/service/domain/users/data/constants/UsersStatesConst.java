package com.personalgarage.service.domain.users.data.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UsersStatesConst {

    NEW("1", "NEW"),
    ACTIVE("2", "ACTIVE"),
    BLOCKED("3", "BLOCKED"),
    DELETED("4", "DELETED");

    private final String id;
    private final String value;

    UsersStatesConst(String id, String value) {
        this.id = id;
        this.value = value;
    }

    @JsonCreator
    public static UsersStatesConst forId(String id) {
        for(UsersStatesConst cnst : UsersStatesConst.values()) {
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