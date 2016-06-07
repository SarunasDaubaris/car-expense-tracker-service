package com.personalgarage.service.repositories;

import com.personalgarage.service.entities.Cars;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends MongoRepository<Cars, String> {
}