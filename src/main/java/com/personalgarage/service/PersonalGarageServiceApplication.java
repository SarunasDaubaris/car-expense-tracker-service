package com.personalgarage.service;

import com.personalgarage.service.main.cars.persistence.repositories.CarRepository;
import com.personalgarage.service.main.transactions.persistence.repositories.TransactionRepository;
import com.personalgarage.service.main.users.persistence.repositories.UserRepository;
import com.personalgarage.service.main.users.persistence.repositories.UserSettingsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.session.SessionAutoConfiguration.class
})
@EnableJpaRepositories(basePackageClasses = {
        UserRepository.class,
        UserSettingsRepository.class,
        CarRepository.class,
        TransactionRepository.class
})
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableTransactionManagement
public class PersonalGarageServiceApplication extends GlobalMethodSecurityConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(PersonalGarageServiceApplication.class, args);
    }
}