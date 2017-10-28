package com.personalgarage.service.main.users.interfaces.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCredentialsDTO {

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;
}