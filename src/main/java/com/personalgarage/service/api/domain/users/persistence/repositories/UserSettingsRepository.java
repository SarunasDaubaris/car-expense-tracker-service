package com.personalgarage.service.api.domain.users.persistence.repositories;

import com.personalgarage.service.api.domain.users.persistence.entities.UserSetting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSettingsRepository extends CrudRepository<UserSetting, Long> {
}