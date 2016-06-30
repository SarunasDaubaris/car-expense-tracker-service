package com.personalgarage.service.base;

interface IDTOService<DTO> {

    DTO get(String id);

    DTO insert(DTO dto);

    DTO update(DTO dto);

    void delete(String id);
}