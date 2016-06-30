package com.personalgarage.service.base.services;

public abstract class DTOBaseService<DTO, ENTITY>
        implements IDTOService<DTO> {

    protected abstract DTO convertToDto(ENTITY entity);

    protected abstract ENTITY convertToEntity(DTO dto);
}