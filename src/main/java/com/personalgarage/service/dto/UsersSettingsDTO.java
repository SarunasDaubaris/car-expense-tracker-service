package com.personalgarage.service.dto;

import com.personalgarage.service.base.dto.BaseDTO;
import com.personalgarage.service.base.validation.groups.ActionInsert;
import com.personalgarage.service.base.validation.groups.ActionUpdate;
import com.personalgarage.service.constants.UsersSettingsTypesConst;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class UsersSettingsDTO extends BaseDTO {

    @NotNull(message = "UsersSettingsTypes cannot be null", groups = { ActionInsert.class, ActionUpdate.class })
    private UsersSettingsTypesConst usersSettingsTypes;
}