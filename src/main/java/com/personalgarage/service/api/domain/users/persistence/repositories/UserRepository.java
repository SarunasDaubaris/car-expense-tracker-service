package com.personalgarage.service.api.domain.users.persistence.repositories;

import com.personalgarage.service.api.domain.users.persistence.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}