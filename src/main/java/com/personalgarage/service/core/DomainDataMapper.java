package com.personalgarage.service.core;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

public class DomainDataMapper<DTO, ENTITY> {

    public DTO convertToDto(ENTITY entity) {
        ModelMapper modelMapper = new ModelMapper();
        TypeToken<DTO> typeToken = new TypeToken<DTO>(){};
        return modelMapper.map(entity, typeToken.getType());
    }

    public List<DTO> convertToDtos(List<ENTITY> entities) {
        ModelMapper modelMapper = new ModelMapper();
        TypeToken<List<DTO>> typeToken = new TypeToken<List<DTO>>(){};
        return modelMapper.map(entities, typeToken.getType());
    }

    public ENTITY convertToEntity(DTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        TypeToken<ENTITY> typeToken = new TypeToken<ENTITY>(){};
        return modelMapper.map(dto, typeToken.getType());
    }

    public List<ENTITY> convertToEntities(List<DTO> dtos) {
        ModelMapper modelMapper = new ModelMapper();
        TypeToken<List<ENTITY>> typeToken = new TypeToken<List<ENTITY>>(){};
        return modelMapper.map(dtos, typeToken.getType());
    }
}