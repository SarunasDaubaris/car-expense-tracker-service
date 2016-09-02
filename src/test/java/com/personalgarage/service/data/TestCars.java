package com.personalgarage.service.data;

import com.personalgarage.service.domain.cars.data.constants.FuelTypesConst;

public enum TestCars {

    BMW_530D_2013("1", "1", "BMW", "535d", 2013, FuelTypesConst.DIESEL, "123456");

    private final String id;
    private final String userId;
    private final String make;
    private final String model;
    private final Integer year;
    private final FuelTypesConst fuelTypes;
    private final String licencePlate;

    TestCars(String id, String userId, String make, String model, Integer year, FuelTypesConst fuelTypes, String licencePlate) {
        this.id = id;
        this.userId = userId;
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelTypes = fuelTypes;
        this.licencePlate = licencePlate;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
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

    public FuelTypesConst getFuelTypes() {
        return fuelTypes;
    }

    public String getLicencePlate() {
        return licencePlate;
    }
}