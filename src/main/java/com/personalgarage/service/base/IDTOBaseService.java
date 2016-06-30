package com.personalgarage.service.base;

public abstract class IDTOBaseService<DTO, ENTITY>
        implements IDTOService<DTO, ENTITY> {

    protected abstract DTO convertToDto(ENTITY entity);

    protected abstract ENTITY convertToEntity(DTO dto);
}