package com.personalgarage.service.main.users.interfaces.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserSettingTypeConst {

    SETTING_1((short) 1, "SETTING 1");

    private final Short id;
    private final String value;

    UserSettingTypeConst(Short id, String value) {
        this.id = id;
        this.value = value;
    }

    @JsonCreator
    public static UserSettingTypeConst forId(Short id) {
        for (UserSettingTypeConst cnst : UserSettingTypeConst.values()) {
            if (cnst.getId().equals(id)) {
                return cnst;
            }
        }
        throw new IllegalArgumentException("Invalid UserSettingTypeConst ID: " + id);
    }

    @JsonValue
    public Short getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}