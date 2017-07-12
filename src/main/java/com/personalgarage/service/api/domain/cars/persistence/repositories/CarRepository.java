package com.personalgarage.service.api.domain.cars.persistence.repositories;

import com.personalgarage.service.api.domain.cars.persistence.entities.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findByUserId(Long userId);
}