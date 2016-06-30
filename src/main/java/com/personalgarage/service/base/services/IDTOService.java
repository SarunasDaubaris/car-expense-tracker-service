package com.personalgarage.service.base.services;

interface IDTOService<DTO> {

    DTO get(String id);

    DTO insert(DTO dto);

    DTO update(DTO dto);

    void delete(String id);
}