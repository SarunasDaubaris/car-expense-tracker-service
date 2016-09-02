package com.personalgarage.service.base.persistence.entities;

import com.personalgarage.service.base.persistence.entities.interfaces.IEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public abstract class BaseEntity implements IEntity {

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}