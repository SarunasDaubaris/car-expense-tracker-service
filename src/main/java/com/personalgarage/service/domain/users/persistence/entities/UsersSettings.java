package com.personalgarage.service.domain.users.persistence.entities;

import com.personalgarage.service.base.persistence.entities.BaseEntity;
import com.personalgarage.service.domain.users.data.constants.UsersSettingsTypesConst;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Document(collection = "usersSettings")
public class UsersSettings extends BaseEntity {

    private UsersSettingsTypesConst usersSettingsTypes;
}