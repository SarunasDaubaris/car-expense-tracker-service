package com.personalgarage.service.api.domain.users.data.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserSettingTypeConst {

    SETTING_1("1", "SETTING 1");

    private final String id;
    private final String value;

    UserSettingTypeConst(String id, String value) {
        this.id = id;
        this.value = value;
    }

    @JsonCreator
    public static UserSettingTypeConst forId(String id) {
        for(UserSettingTypeConst cnst : UserSettingTypeConst.values()) {
            if(cnst.getId().equals(id)) {
                return cnst;
            }
        }
        throw new IllegalArgumentException("Invalid UsersSettingsTypesConst ID: " + id);
    }

    @JsonValue
    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}