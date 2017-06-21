package com.personalgarage.service.api.domain.cars.persistence.entities;

import com.personalgarage.service.api.domain.cars.data.constants.FuelTypeConst;
import com.personalgarage.service.api.domain.users.persistence.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "fuel_type")
    @Enumerated(EnumType.ORDINAL)
    private FuelTypeConst fuelType;

    @Column(name = "licence_plate")
    private String licencePlate;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "manufacture_year")
    private Integer manufactureYear;
}