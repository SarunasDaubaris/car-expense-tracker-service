package com.personalgarage.service.data;

import com.personalgarage.service.main.cars.data.constants.FuelTypeConst;

public enum TestCars {

    BMW_530D_2013(1L, 1L, "BMW", "535d", 2013, FuelTypeConst.DIESEL, "123456");

    private final Long id;
    private final Long userId;
    private final String make;
    private final String model;
    private final Integer year;
    private final FuelTypeConst fuelTypes;
    private final String licencePlate;

    TestCars(Long id, Long userId, String make, String model, Integer year, FuelTypeConst fuelTypes, String licencePlate) {
        this.id = id;
        this.userId = userId;
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelTypes = fuelTypes;
        this.licencePlate = licencePlate;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public FuelTypeConst getFuelTypes() {
        return fuelTypes;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }
}