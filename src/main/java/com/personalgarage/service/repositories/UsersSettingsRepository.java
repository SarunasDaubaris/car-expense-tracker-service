package com.personalgarage.service.repositories;

import com.personalgarage.service.entities.UsersSettings;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersSettingsRepository
        extends MongoRepository<UsersSettings, String> {
}