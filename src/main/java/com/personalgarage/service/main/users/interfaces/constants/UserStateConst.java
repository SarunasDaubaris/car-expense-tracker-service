package com.personalgarage.service.main.users.interfaces.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserStateConst {

    NEW((short) 1, "NEW"),
    ACTIVE((short) 2, "ACTIVE"),
    BLOCKED((short) 3, "BLOCKED"),
    DELETED((short) 4, "DELETED");

    private final Short id;
    private final String value;

    UserStateConst(Short id, String value) {
        this.id = id;
        this.value = value;
    }

    @JsonCreator
    public static UserStateConst forId(Short id) {
        for (UserStateConst cnst : UserStateConst.values()) {
            if (cnst.getId().equals(id)) {
                return cnst;
            }
        }
        throw new IllegalArgumentException("Invalid UserStateConst ID: " + id);
    }

    @JsonValue
    public Short getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}