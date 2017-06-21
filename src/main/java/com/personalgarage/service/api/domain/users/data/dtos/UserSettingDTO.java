package com.personalgarage.service.api.domain.users.data.dtos;

import com.personalgarage.service.api.domain.users.data.constants.UserSettingTypeConst;
import com.personalgarage.service.common.validation.groups.ActionInsert;
import com.personalgarage.service.common.validation.groups.ActionUpdate;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@NoArgsConstructor
public class UserSettingDTO {

    @Null(message = "Id must be null", groups = {ActionInsert.class})
    @NotNull(message = "Id cannot be null", groups = {ActionUpdate.class})
    private Long id;

    @NotNull(message = "UserSettingsType cannot be null", groups = {ActionInsert.class, ActionUpdate.class})
    private UserSettingTypeConst usersSettingsTypes;

    @NotNull(message = "User cannot be null", groups = {ActionInsert.class, ActionUpdate.class})
    private UserDTO user;

    @NotNull(message = "SettingKey cannot be null", groups = {ActionInsert.class, ActionUpdate.class})
    private String settingKey;

    @NotNull(message = "SettingValue cannot be null", groups = {ActionInsert.class, ActionUpdate.class})
    private String settingValue;
}