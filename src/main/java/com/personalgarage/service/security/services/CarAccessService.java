package com.personalgarage.service.security.services;

import com.personalgarage.service.main.cars.persistence.entities.Car;
import com.personalgarage.service.main.cars.persistence.repositories.CarRepository;
import com.personalgarage.service.main.users.persistence.entities.ApplicationUser;
import com.personalgarage.service.main.users.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class CarAccessService {

    private final UserRepository userRepository;
    private final CarRepository carRepository;

    @Autowired
    public CarAccessService(UserRepository userRepository, CarRepository carRepository) {
        this.userRepository = userRepository;
        this.carRepository = carRepository;
    }

    public boolean isAccessibleWithCarId(Authentication authentication, Long carId) {
        if (authentication != null && carId != null) {
            ApplicationUser applicationUser = userRepository.findByUsername(authentication.getName());
            Car car = carRepository.findById(carId).orElse(null);
            return car != null && applicationUser != null && car.getUser().getId().equals(applicationUser.getId());
        }
        return false;
    }
}