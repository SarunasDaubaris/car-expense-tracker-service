package com.personalgarage.service.domain.users.data.dtos;

import com.personalgarage.service.base.data.dto.BaseDTO;
import com.personalgarage.service.core.validation.groups.ActionInsert;
import com.personalgarage.service.core.validation.groups.ActionUpdate;
import com.personalgarage.service.domain.users.data.constants.UsersStatesConst;
import com.personalgarage.service.domain.users.data.constants.UsersTypesConst;
import com.personalgarage.service.domain.users.persistence.entities.UsersSettings;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
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