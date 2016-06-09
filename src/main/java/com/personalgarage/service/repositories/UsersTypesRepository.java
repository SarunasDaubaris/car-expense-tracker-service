package com.personalgarage.service.repositories;

import com.personalgarage.service.entities.UsersTypes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersTypesRepository extends MongoRepository<UsersTypes, String> {
}