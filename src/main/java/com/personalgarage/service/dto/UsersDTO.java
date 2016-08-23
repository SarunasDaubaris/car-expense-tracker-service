package com.personalgarage.service.dto;

import com.personalgarage.service.base.dto.BaseDTO;
import com.personalgarage.service.base.validation.groups.ActionInsert;
import com.personalgarage.service.base.validation.groups.ActionUpdate;
import com.personalgarage.service.constants.UsersStatesConst;
import com.personalgarage.service.constants.UsersTypesConst;
import com.personalgarage.service.entities.UsersSettings;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
public class UsersDTO extends BaseDTO {

    @NotBlank(message = "Username cannot be blank", groups = { ActionInsert.class, ActionUpdate.class })
    private String username;

    @NotNull(message = "UsersStates cannot be null", groups = { ActionInsert.class, ActionUpdate.class })
    private UsersStatesConst usersStates;

    @NotNull(message = "UsersTypes cannot be null", groups = { ActionInsert.class, ActionUpdate.class })
    private UsersTypesConst usersTypes;

    @NotNull(message = "UsersSettings cannot be null", groups = { ActionInsert.class, ActionUpdate.class })
    private List<UsersSettings> usersSettings;
}