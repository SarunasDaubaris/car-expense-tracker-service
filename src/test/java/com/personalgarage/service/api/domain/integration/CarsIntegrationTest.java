package com.personalgarage.service.api.domain.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personalgarage.service.base.BaseTest;
import com.personalgarage.service.data.TestCars;
import com.personalgarage.service.data.TestUsers;
import com.personalgarage.service.api.domain.cars.application.CarsController;
import com.personalgarage.service.api.domain.cars.data.dtos.CarsDTO;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CarsIntegrationTest extends BaseTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarsController carsController;

    @Test
    @WithMockUser
    public void givenValidCarIdReturnsCarDTO() throws Exception {
        CarsDTO car = new CarsDTO();
        car.setId(TestCars.BMW_530D_2013.getId());
        when(carsController.get(TestCars.BMW_530D_2013.getId())).thenReturn(car);

        mockMvc.perform(get("/cars/{id}", TestCars.BMW_530D_2013.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", equalTo(TestCars.BMW_530D_2013.getId())));

        verify(carsController, times(1)).get(TestCars.BMW_530D_2013.getId());
        verifyNoMoreInteractions(carsController);
    }

    @Test
    @WithMockUser
    public void givenValidUserIdReturnsCarDTOList() throws Exception {
        CarsDTO car = new CarsDTO();
        car.setId(TestCars.BMW_530D_2013.getId());
        car.setUserId(TestCars.BMW_530D_2013.getUserId());
        List<CarsDTO> userCars = new ArrayList<>();
        userCars.add(car);
        when(carsController.getAllByUserId(TestUsers.USER_1.getId())).thenReturn(userCars);

        mockMvc.perform(get("/cars/users/{userId}", TestUsers.USER_1.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", equalTo((ArgumentMatcher<List<LinkedHashMap<String, String>>>) argument ->
                        !CollectionUtils.isEmpty(argument)
                                && argument.size() == 1
                                && argument.get(0).get("id").equals(TestCars.BMW_530D_2013.getId())
                                && argument.get(0).get("userId").equals(TestCars.BMW_530D_2013.getUserId()))));

        verify(carsController, times(1)).getAllByUserId(TestUsers.USER_1.getId());
        verifyNoMoreInteractions(carsController);
    }

    @Test
    @WithMockUser
    public void givenValidCarDTOReturnsInsertedCarDTO() throws Exception {
        CarsDTO insertCar = new CarsDTO();
        insertCar.setId(null);
        insertCar.setUserId(TestCars.BMW_530D_2013.getUserId());
        insertCar.setMake(TestCars.BMW_530D_2013.getMake());
        insertCar.setModel(TestCars.BMW_530D_2013.getModel());
        insertCar.setYear(TestCars.BMW_530D_2013.getYear());
        insertCar.setFuelTypes(TestCars.BMW_530D_2013.getFuelTypes());
        insertCar.setLicencePlate(TestCars.BMW_530D_2013.getLicencePlate());

        CarsDTO resultCar = new CarsDTO();
        resultCar.setId(TestCars.BMW_530D_2013.getId());
        resultCar.setUserId(TestUsers.USER_1.getId());
        resultCar.setMake(TestCars.BMW_530D_2013.getMake());
        resultCar.setModel(TestCars.BMW_530D_2013.getModel());
        resultCar.setYear(TestCars.BMW_530D_2013.getYear());
        resultCar.setFuelTypes(TestCars.BMW_530D_2013.getFuelTypes());
        resultCar.setLicencePlate(TestCars.BMW_530D_2013.getLicencePlate());

        when(carsController.insert(insertCar)).thenReturn(resultCar);

        mockMvc.perform(post("/cars")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writer().writeValueAsBytes(insertCar)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", equalTo((ArgumentMatcher<LinkedHashMap<String, String>>) argument ->
                        argument.get("id").equals(TestCars.BMW_530D_2013.getId())
                                && argument.get("userId").equals(TestCars.BMW_530D_2013.getUserId()))));

        verify(carsController, times(1)).insert(insertCar);
        verifyNoMoreInteractions(carsController);
    }

    @Test
    @WithMockUser
    public void givenValidCarDTOReturnsUpdatedCarDTO() throws Exception {
        CarsDTO updateCar = new CarsDTO();
        updateCar.setId(TestCars.BMW_530D_2013.getId());
        updateCar.setUserId(TestCars.BMW_530D_2013.getUserId());
        updateCar.setMake(TestCars.BMW_530D_2013.getMake());
        updateCar.setModel(TestCars.BMW_530D_2013.getModel());
        updateCar.setYear(TestCars.BMW_530D_2013.getYear());
        updateCar.setFuelTypes(TestCars.BMW_530D_2013.getFuelTypes());
        updateCar.setLicencePlate(TestCars.BMW_530D_2013.getLicencePlate());

        CarsDTO resultCar = new CarsDTO();
        resultCar.setId(TestCars.BMW_530D_2013.getId());
        resultCar.setUserId(TestUsers.USER_1.getId());
        resultCar.setMake(TestCars.BMW_530D_2013.getMake());
        resultCar.setModel(TestCars.BMW_530D_2013.getModel());
        resultCar.setYear(TestCars.BMW_530D_2013.getYear());
        resultCar.setFuelTypes(TestCars.BMW_530D_2013.getFuelTypes());
        resultCar.setLicencePlate(TestCars.BMW_530D_2013.getLicencePlate());

        when(carsController.update(updateCar)).thenReturn(resultCar);

        mockMvc.perform(put("/cars")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writer().writeValueAsBytes(updateCar)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", equalTo((ArgumentMatcher<LinkedHashMap<String, String>>) argument ->
                        argument.get("id").equals(TestCars.BMW_530D_2013.getId()))));

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