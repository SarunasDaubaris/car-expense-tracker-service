package com.personalgarage.service.main.users.interfaces.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.personalgarage.service.common.components.JacksonJodaDateTimeDeserializer;
import com.personalgarage.service.main.users.interfaces.constants.UserStateConst;
import com.personalgarage.service.main.users.interfaces.constants.UserTypeConst;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

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

    @JsonProperty(value = "createdDate", access = JsonProperty.Access.READ_ONLY)
    @JsonDeserialize(using = JacksonJodaDateTimeDeserializer.class)
    private DateTime createdDate;

    @JsonProperty("userState")
    private UserStateConst userState;

    @JsonProperty("userType")
    private UserTypeConst userType;

    @JsonProperty("userSettings")
    private List<UserSettingDTO> userSettings;
}