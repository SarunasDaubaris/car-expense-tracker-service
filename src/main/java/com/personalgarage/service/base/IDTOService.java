package com.personalgarage.service.base;

import java.util.List;

public interface IDTOService<DTO, ENTITY> {

    List<DTO> getAll();

    DTO get(String id);

    DTO insert(DTO dto);

    DTO update(DTO dto);

    void delete(String id);
}