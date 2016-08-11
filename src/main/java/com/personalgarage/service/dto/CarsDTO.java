package com.personalgarage.service.dto;

import com.personalgarage.service.base.dto.BaseDTO;
import com.personalgarage.service.base.validation.groups.ActionInsert;
import com.personalgarage.service.base.validation.groups.ActionUpdate;

import javax.validation.constraints.NotNull;

public class CarsDTO extends BaseDTO {

    private String owner;

    @NotNull(message = "Make cannot be null", groups = { ActionInsert.class, ActionUpdate.class })
    private String make;

    @NotNull(message = "Model cannot be null", groups = { ActionInsert.class, ActionUpdate.class })
    private String model;

    @NotNull(message = "Year cannot be null", groups = { ActionInsert.class, ActionUpdate.class })
    private Integer year;

    @NotNull(message = "FuelTypes cannot be null", groups = { ActionInsert.class, ActionUpdate.class })
    private FuelTypesDTO fuelTypes;

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

    public FuelTypesDTO getFuelTypes() {
        return fuelTypes;
    }

    public void setFuelTypes(FuelTypesDTO fuelTypes) {
        this.fuelTypes = fuelTypes;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }
}