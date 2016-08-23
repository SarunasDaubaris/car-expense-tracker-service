package com.personalgarage.service.data;

import com.personalgarage.service.constants.FuelTypesConst;

public enum TestCars {

    BMW_530D_2013("1", "1", "BMW", "535d", 2013, FuelTypesConst.DIESEL, "123456");

    private final String id;
    private final String owner;
    private final String make;
    private final String model;
    private final Integer year;
    private final FuelTypesConst fuelTypes;
    private final String licencePlate;

    TestCars(String id, String owner, String make, String model, Integer year, FuelTypesConst fuelTypes, String licencePlate) {
        this.id = id;
        this.owner = owner;
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelTypes = fuelTypes;
        this.licencePlate = licencePlate;
    }

    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
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