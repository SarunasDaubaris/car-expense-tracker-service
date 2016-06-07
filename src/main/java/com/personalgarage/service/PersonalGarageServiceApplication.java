package com.personalgarage.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {
		org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class
})
@EnableMongoRepositories("com.personalgarage.service.repositories")
public class PersonalGarageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalGarageServiceApplication.class, args);
	}
}