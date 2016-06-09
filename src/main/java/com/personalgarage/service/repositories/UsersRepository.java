package com.personalgarage.service.repositories;

import com.personalgarage.service.entities.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends MongoRepository<Users, String> {
}