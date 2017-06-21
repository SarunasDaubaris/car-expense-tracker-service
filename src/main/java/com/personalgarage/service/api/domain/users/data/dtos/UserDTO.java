package com.personalgarage.service.api.domain.users.data.dtos;

import com.personalgarage.service.api.domain.users.data.constants.UserStateConst;
import com.personalgarage.service.api.domain.users.data.constants.UserTypeConst;
import com.personalgarage.service.common.validation.groups.ActionInsert;
import com.personalgarage.service.common.validation.groups.ActionUpdate;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO {

    @Null(message = "Id must be null", groups = {ActionInsert.class})
    @NotNull(message = "Id cannot be null", groups = {ActionUpdate.class})
    private Long id;

    @NotBlank(message = "Username cannot be blank", groups = {ActionInsert.class, ActionUpdate.class})
    private String username;

    @NotNull(message = "UserState cannot be null", groups = {ActionInsert.class, ActionUpdate.class})
    private UserStateConst userState;

    @NotNull(message = "UserType cannot be null", groups = {ActionInsert.class, ActionUpdate.class})
    private UserTypeConst userType;

    @NotNull(message = "UserSettings cannot be null", groups = {ActionInsert.class, ActionUpdate.class})
    private List<UserSettingDTO> userSettings;
}