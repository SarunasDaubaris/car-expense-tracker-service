package com.personalgarage.service.main.users.interfaces.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.personalgarage.service.main.users.interfaces.constants.UserSettingTypeConst;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserSettingDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("userSettingType")
    private UserSettingTypeConst userSettingType;

    @JsonProperty("userId")
    private Long userId;

    @JsonProperty("settingKey")
    private String settingKey;

    @JsonProperty("settingValue")
    private String settingValue;
}