package com.personalgarage.service.api.domain.users.persistence.repositories;

import com.personalgarage.service.api.domain.users.persistence.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}