package com.personalgarage.service.dto;

import com.personalgarage.service.base.dto.BaseDTO;

public class CarsDTO extends BaseDTO {

    private String owner;
    private String make;
    private String model;
    private Integer year;
    private String fuelTypes;
    private String licencePlate;

    public CarsDTO() {}

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getFuelTypes() {
        return fuelTypes;
    }

    public void setFuelTypes(String fuelTypes) {
        this.fuelTypes = fuelTypes;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }
}