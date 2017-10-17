package com.personalgarage.service.main.users.persistence.repositories;

import com.personalgarage.service.main.users.persistence.entities.UserSetting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSettingsRepository extends CrudRepository<UserSetting, Long> {
}