package com.personalgarage.service.api.domain.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personalgarage.service.api.domain.cars.application.CarController;
import com.personalgarage.service.api.domain.cars.data.dtos.CarDTO;
import com.personalgarage.service.api.domain.users.data.dtos.UserDTO;
import com.personalgarage.service.base.BaseTest;
import com.personalgarage.service.data.TestCars;
import com.personalgarage.service.data.TestUsers;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
        when(carsController.get(TestCars.BMW_530D_2013.getId())).thenReturn(car);

        mockMvc.perform(get("/cars/{id}", TestCars.BMW_530D_2013.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", equalTo(TestCars.BMW_530D_2013.getId().intValue())));

        verify(carsController, times(1)).get(TestCars.BMW_530D_2013.getId());
        verifyNoMoreInteractions(carsController);
    }

    @Test
    @WithMockUser
    public void givenValidUserIdReturnsCarDTOList() throws Exception {
        UserDTO user = new UserDTO();
        user.setId(TestCars.BMW_530D_2013.getUserId());

        CarDTO car = new CarDTO();
        car.setId(TestCars.BMW_530D_2013.getId());
        car.setUser(user);
        List<CarDTO> userCars = new ArrayList<>();
        userCars.add(car);
        when(carsController.getAllByUserId(TestUsers.USER_1.getId())).thenReturn(userCars);

        mockMvc.perform(get("/cars/users/{userId}", TestUsers.USER_1.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$.[0].id", is(TestCars.BMW_530D_2013.getId().intValue())))
                .andExpect(jsonPath("$.[0].user.id", is(TestCars.BMW_530D_2013.getUserId().intValue())));

        verify(carsController, times(1)).getAllByUserId(TestUsers.USER_1.getId());
        verifyNoMoreInteractions(carsController);
    }

    @Test
    @WithMockUser
    public void givenValidCarDTOReturnsInsertedCarDTO() throws Exception {
        UserDTO user = new UserDTO();
        user.setId(TestCars.BMW_530D_2013.getUserId());

        CarDTO insertCar = new CarDTO();
        insertCar.setId(null);
        insertCar.setUser(user);
        insertCar.setMake(TestCars.BMW_530D_2013.getMake());
        insertCar.setModel(TestCars.BMW_530D_2013.getModel());
        insertCar.setManufactureYear(TestCars.BMW_530D_2013.getYear());
        insertCar.setFuelType(TestCars.BMW_530D_2013.getFuelTypes());
        insertCar.setLicencePlate(TestCars.BMW_530D_2013.getLicencePlate());

        CarDTO resultCar = new CarDTO();
        resultCar.setId(TestCars.BMW_530D_2013.getId());
        resultCar.setUser(user);
        resultCar.setMake(TestCars.BMW_530D_2013.getMake());
        resultCar.setModel(TestCars.BMW_530D_2013.getModel());
        resultCar.setManufactureYear(TestCars.BMW_530D_2013.getYear());
        resultCar.setFuelType(TestCars.BMW_530D_2013.getFuelTypes());
        resultCar.setLicencePlate(TestCars.BMW_530D_2013.getLicencePlate());

        when(carsController.insert(insertCar)).thenReturn(resultCar);

        mockMvc.perform(post("/cars")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writer().writeValueAsBytes(insertCar)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(TestCars.BMW_530D_2013.getId().intValue())))
                .andExpect(jsonPath("$.user.id", is(TestCars.BMW_530D_2013.getUserId().intValue())));

        verify(carsController, times(1)).insert(insertCar);
        verifyNoMoreInteractions(carsController);
    }

    @Test
    @WithMockUser
    public void givenValidCarDTOReturnsUpdatedCarDTO() throws Exception {
        UserDTO user = new UserDTO();
        user.setId(TestCars.BMW_530D_2013.getUserId());

        CarDTO updateCar = new CarDTO();
        updateCar.setId(TestCars.BMW_530D_2013.getId());
        updateCar.setUser(user);
        updateCar.setMake(TestCars.BMW_530D_2013.getMake());
        updateCar.setModel(TestCars.BMW_530D_2013.getModel());
        updateCar.setManufactureYear(TestCars.BMW_530D_2013.getYear());
        updateCar.setFuelType(TestCars.BMW_530D_2013.getFuelTypes());
        updateCar.setLicencePlate(TestCars.BMW_530D_2013.getLicencePlate());

        CarDTO resultCar = new CarDTO();
        resultCar.setId(TestCars.BMW_530D_2013.getId());
        resultCar.setUser(user);
        resultCar.setMake(TestCars.BMW_530D_2013.getMake());
        resultCar.setModel(TestCars.BMW_530D_2013.getModel());
        resultCar.setManufactureYear(TestCars.BMW_530D_2013.getYear());
        resultCar.setFuelType(TestCars.BMW_530D_2013.getFuelTypes());
        resultCar.setLicencePlate(TestCars.BMW_530D_2013.getLicencePlate());

        when(carsController.update(updateCar)).thenReturn(resultCar);

        mockMvc.perform(put("/cars")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writer().writeValueAsBytes(updateCar)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(TestCars.BMW_530D_2013.getId().intValue())));

        verify(carsController, times(1)).update(updateCar);
        verifyNoMoreInteractions(carsController);
    }

    @Test
    @WithMockUser
    public void givenValidDeleteCarIdReturnsNoContent() throws Exception {
        mockMvc.perform(delete("/cars/{id}", TestCars.BMW_530D_2013.getId()))
                .andExpect(status().isNoContent());

        verify(carsController, times(1)).delete(TestCars.BMW_530D_2013.getId());
        verifyNoMoreInteractions(carsController);
    }
}