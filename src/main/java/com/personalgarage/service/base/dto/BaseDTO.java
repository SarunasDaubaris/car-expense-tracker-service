package com.personalgarage.service.base.dto;

public abstract class BaseDTO implements IDTO {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}