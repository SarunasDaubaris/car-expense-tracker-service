package com.personalgarage.service.main.users.data.dtos;

import com.personalgarage.service.main.users.data.constants.UserSettingTypeConst;
import com.personalgarage.service.common.validation.groups.ActionInsert;
import com.personalgarage.service.common.validation.groups.ActionUpdate;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class UserSettingDTO {

    @NotNull(message = "Id cannot be null", groups = {ActionUpdate.class})
    private Long id;

    @NotNull(message = "UserSettingsType cannot be null", groups = {ActionInsert.class, ActionUpdate.class})
    private UserSettingTypeConst usersSettingsTypes;

    @NotNull(message = "UserId cannot be null", groups = {ActionInsert.class, ActionUpdate.class})
    private Long userId;

    @NotNull(message = "SettingKey cannot be null", groups = {ActionInsert.class, ActionUpdate.class})
    private String settingKey;

    @NotNull(message = "SettingValue cannot be null", groups = {ActionInsert.class, ActionUpdate.class})
    private String settingValue;
}