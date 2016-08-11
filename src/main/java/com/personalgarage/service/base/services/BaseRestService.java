package com.personalgarage.service.base.services;

public abstract class BaseRestService<DTO, ENTITY> {

    protected abstract DTO convertToDto(ENTITY entity);

    protected abstract ENTITY convertToEntity(DTO dto);
}