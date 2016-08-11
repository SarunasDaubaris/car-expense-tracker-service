package com.personalgarage.service.repositories;

import com.personalgarage.service.base.repositories.IRepository;
import com.personalgarage.service.entities.Cars;

import java.util.List;

public interface CarsRepository extends IRepository<Cars, String> {

    List<Cars> findByOwner(String owner);
}