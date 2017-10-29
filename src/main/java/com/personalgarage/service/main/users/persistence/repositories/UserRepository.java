package com.personalgarage.service.main.users.persistence.repositories;

import com.personalgarage.service.main.users.persistence.entities.ApplicationUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<ApplicationUser, Long> {

    boolean existsByUsername(String username);

    ApplicationUser findByUsername(String username);
}