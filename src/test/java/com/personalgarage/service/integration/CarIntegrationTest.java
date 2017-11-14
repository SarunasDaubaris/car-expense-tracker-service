package com.personalgarage.service.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personalgarage.service.base.BaseTest;
import com.personalgarage.service.data.TestCars;
import com.personalgarage.service.data.TestUsers;
import com.personalgarage.service.main.cars.application.CarController;
import com.personalgarage.service.main.cars.interfaces.dtos.CarDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CarIntegrationTest extends BaseTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarController carsController;

    @Test
    @WithMockUser
    public void givenValidCarIdReturnsCarDTO() throws Exception {
        CarDTO car = new CarDTO();
        car.setId(TestCars.BMW_530D_2013.getId());
        when(carsController.getCarById(TestCars.BMW_530D_2013.getId())).thenReturn(car);

        mockMvc.perform(get("/cars/{id}", TestCars.BMW_530D_2013.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", equalTo(TestCars.BMW_530D_2013.getId().intValue())));

        verify(carsController, times(1)).getCarById(TestCars.BMW_530D_2013.getId());
        verifyNoMoreInteractions(carsController);
    }

    @Test
    @WithMockUser
    public void givenValidUserIdReturnsCarDTOList() throws Exception {
        CarDTO car = new CarDTO();
        car.setId(TestCars.BMW_530D_2013.getId());
        car.setUserId(TestCars.BMW_530D_2013.getUserId());
        List<CarDTO> userCars = new ArrayList<>();
        userCars.add(car);
        when(carsController.getAllCarsByUserId(TestUsers.USER_1.getId())).thenReturn(userCars);

        mockMvc.perform(get("/cars/users/{userId}", TestUsers.USER_1.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$.[0].id", is(TestCars.BMW_530D_2013.getId().intValue())))
                .andExpect(jsonPath("$.[0].userId", is(TestCars.BMW_530D_2013.getUserId().intValue())));

        verify(carsController, times(1)).getAllCarsByUserId(TestUsers.USER_1.getId());
        verifyNoMoreInteractions(carsController);
    }

    @Test
    @WithMockUser
    public void givenValidCarDTOReturnsInsertedCarDTOId() throws Exception {
        CarDTO insertCar = new CarDTO();
        insertCar.setId(null);
        insertCar.setUserId(TestCars.BMW_530D_2013.getUserId());
        insertCar.setMake(TestCars.BMW_530D_2013.getMake());
        insertCar.setModel(TestCars.BMW_530D_2013.getModel());
        insertCar.setManufactureYear(TestCars.BMW_530D_2013.getYear());
        insertCar.setFuelType(TestCars.BMW_530D_2013.getFuelTypes());
        insertCar.setLicencePlate(TestCars.BMW_530D_2013.getLicencePlate());

        when(carsController.createCar(insertCar)).thenReturn(TestCars.BMW_530D_2013.getId());

        mockMvc.perform(post("/cars")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writer().writeValueAsBytes(insertCar)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(TestCars.BMW_530D_2013.getId().intValue())));

        verify(carsController, times(1)).createCar(insertCar);
        verifyNoMoreInteractions(carsController);
    }
}