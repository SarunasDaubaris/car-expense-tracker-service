package com.personalgarage.service.base.services.interfaces;

import org.springframework.stereotype.Service;

@Service
public interface IRestService<DTO> {

    DTO get(String id);

    DTO insert(DTO dto);

    DTO update(DTO dto);

    void delete(String id);
}