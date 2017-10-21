package com.personalgarage.service.main.cars.persistence.entities;

import com.personalgarage.service.interfaces.main.cars.constants.FuelTypeConst;
import com.personalgarage.service.main.users.persistence.entities.User;
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
    private Short fuelTypeId;

    @Column(name = "licence_plate")
    private String licencePlate;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "manufacture_year")
    private Integer manufactureYear;

    public FuelTypeConst getFuelType() {
        return FuelTypeConst.forId(fuelTypeId);
    }

    public void setFuelType(FuelTypeConst fuelType) {
        this.fuelTypeId = fuelType.getId();
    }
}