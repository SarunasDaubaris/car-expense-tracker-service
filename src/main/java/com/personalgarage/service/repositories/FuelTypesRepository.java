package com.personalgarage.service.repositories;

import com.personalgarage.service.entities.FuelTypes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelTypesRepository extends MongoRepository<FuelTypes, String> {
}