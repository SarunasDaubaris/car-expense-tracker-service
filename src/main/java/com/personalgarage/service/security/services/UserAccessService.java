package com.personalgarage.service.security.services;

import com.personalgarage.service.main.users.persistence.entities.ApplicationUser;
import com.personalgarage.service.main.users.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserAccessService {

    private final UserRepository userRepository;

    @Autowired
    public UserAccessService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isAccessibleWithUserId(Authentication authentication, Long userId) {
        if (authentication != null && userId != null) {
            ApplicationUser applicationUser = userRepository.findByUsername(authentication.getName());
            return applicationUser != null && applicationUser.getId().equals(userId);
        }
        return false;
    }
}