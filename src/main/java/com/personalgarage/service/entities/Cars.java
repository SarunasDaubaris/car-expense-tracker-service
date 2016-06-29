package com.personalgarage.service.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cars")
public final class Cars {

    @Id
    private String id;
    private String owner;
    private String make;
    private String model;
    private Integer year;
    private FuelTypes fuelTypes;
    private String licencePlate;

    public Cars() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public FuelTypes getFuelTypes() {
        return fuelTypes;
    }

    public void setFuelTypes(FuelTypes fuelTypes) {
        this.fuelTypes = fuelTypes;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }
}