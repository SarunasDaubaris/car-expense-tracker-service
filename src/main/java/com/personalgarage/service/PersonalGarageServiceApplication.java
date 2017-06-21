package com.personalgarage.service;

import com.personalgarage.service.api.domain.cars.persistence.repositories.CarRepository;
import com.personalgarage.service.api.domain.transactions.persistence.repositories.TransactionsRepository;
import com.personalgarage.service.api.domain.users.persistence.repositories.UserRepository;
import com.personalgarage.service.api.domain.users.persistence.repositories.UserSettingsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
        org.springframework.boot.autoconfigure.session.SessionAutoConfiguration.class
})
@EnableMongoRepositories(basePackageClasses = {
        TransactionsRepository.class
})
@EnableJpaRepositories(basePackageClasses = {
        UserRepository.class,
        UserSettingsRepository.class,
        CarRepository.class
})
public class PersonalGarageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonalGarageServiceApplication.class, args);
    }
}