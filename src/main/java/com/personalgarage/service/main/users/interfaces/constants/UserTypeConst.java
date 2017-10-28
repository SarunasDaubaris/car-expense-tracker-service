package com.personalgarage.service.main.users.interfaces.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserTypeConst {

    BASIC((short) 1, "BASIC"),
    PREMIUM((short) 2, "PREMIUM");

    private final Short id;
    private final String value;

    UserTypeConst(Short id, String value) {
        this.id = id;
        this.value = value;
    }

    @JsonCreator
    public static UserTypeConst forId(Short id) {
        for (UserTypeConst cnst : UserTypeConst.values()) {
            if (cnst.getId().equals(id)) {
                return cnst;
            }
        }
        throw new IllegalArgumentException("Invalid UserTypeConst ID: " + id);
    }

    @JsonValue
    public Short getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}