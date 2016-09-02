package com.personalgarage.service;

import com.personalgarage.service.domain.cars.persistence.repositories.CarsRepository;
import com.personalgarage.service.domain.transactions.persistence.repositories.TransactionsRepository;
import com.personalgarage.service.domain.users.persistence.repositories.UsersRepository;
import com.personalgarage.service.domain.users.persistence.repositories.UsersSettingsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {
		org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class
})
@EnableMongoRepositories(basePackageClasses = {
		CarsRepository.class,
		TransactionsRepository.class,
		UsersRepository.class,
		UsersSettingsRepository.class
})
public class PersonalGarageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalGarageServiceApplication.class, args);
	}
}