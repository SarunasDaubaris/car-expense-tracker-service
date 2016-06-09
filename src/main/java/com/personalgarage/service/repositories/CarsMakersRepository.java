package com.personalgarage.service.repositories;

import com.personalgarage.service.entities.CarsMakers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsMakersRepository extends MongoRepository<CarsMakers, String> {
}