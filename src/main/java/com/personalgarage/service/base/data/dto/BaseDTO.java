package com.personalgarage.service.base.data.dto;

import com.personalgarage.service.base.data.dto.interfaces.IDTO;
import com.personalgarage.service.core.validation.groups.ActionInsert;
import com.personalgarage.service.core.validation.groups.ActionUpdate;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Null;

@Data
@NoArgsConstructor
public abstract class BaseDTO implements IDTO {

    @Null(message = "Id must be null", groups = {ActionInsert.class })
    @NotBlank(message = "Id cannot be blank", groups = { ActionUpdate.class })
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}