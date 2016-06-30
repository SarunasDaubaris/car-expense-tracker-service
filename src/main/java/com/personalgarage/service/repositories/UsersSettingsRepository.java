package com.personalgarage.service.repositories;

import com.personalgarage.service.base.repositories.IRepository;
import com.personalgarage.service.entities.UsersSettings;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersSettingsRepository
        extends IRepository<UsersSettings, String> {
}