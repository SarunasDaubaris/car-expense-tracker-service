package com.personalgarage.service.main.users.interfaces.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.personalgarage.service.main.users.interfaces.constants.UserStateConst;
import com.personalgarage.service.main.users.interfaces.constants.UserTypeConst;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("username")
    private String username;

    @JsonProperty(value = "password", access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @JsonProperty("userState")
    private UserStateConst userState;

    @JsonProperty("userType")
    private UserTypeConst userType;

    @JsonProperty("userSettings")
    private List<UserSettingDTO> userSettings;
}