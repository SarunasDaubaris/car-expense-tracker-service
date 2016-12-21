package com.personalgarage.service.api.domain.users.data.dtos;

import com.personalgarage.service.api.domain.users.data.constants.UsersSettingsTypesConst;
import com.personalgarage.service.base.data.dto.BaseDTO;
import com.personalgarage.service.common.validation.groups.ActionInsert;
import com.personalgarage.service.common.validation.groups.ActionUpdate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UsersSettingsDTO extends BaseDTO {

    @NotNull(message = "UsersSettingsTypes cannot be null", groups = { ActionInsert.class, ActionUpdate.class })
    private UsersSettingsTypesConst usersSettingsTypes;
}