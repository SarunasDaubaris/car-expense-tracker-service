package com.personalgarage.service.main.users.persistence.repositories;

import com.personalgarage.service.main.users.persistence.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}