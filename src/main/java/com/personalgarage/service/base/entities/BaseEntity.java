package com.personalgarage.service.base.entities;

import org.springframework.data.annotation.Id;

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