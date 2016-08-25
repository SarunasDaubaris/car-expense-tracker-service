package com.personalgarage.service.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personalgarage.service.BaseTest;
import com.personalgarage.service.controllers.CarsController;
import com.personalgarage.service.data.TestCars;
import com.personalgarage.service.data.TestUsers;
import com.personalgarage.service.dto.CarsDTO;
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

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
                .andExpect(jsonPath("id", new ArgumentMatcher<String>() {
                    @Override
                    public boolean matches(Object argument) {
                        return TestCars.BMW_530D_2013.getId().equals(argument);
                    }
                }));

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
                .andExpect(jsonPath("$", new ArgumentMatcher<List<LinkedHashMap<String, String>>>() {
                    @Override
                    public boolean matches(Object argument) {
                        List<LinkedHashMap<String, String>> list = (List<LinkedHashMap<String, String>>) argument;
                        return !CollectionUtils.isEmpty(list)
                                && list.size() == 1
                                && list.get(0).get("id").equals(TestCars.BMW_530D_2013.getId())
                                && list.get(0).get("userId").equals(TestCars.BMW_530D_2013.getUserId());
                    }
                }));

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
                .andExpect(jsonPath("$", new ArgumentMatcher<LinkedHashMap<String, String>>() {
                    @Override
                    public boolean matches(Object argument) {
                        LinkedHashMap<String, String> result = (LinkedHashMap<String, String>) argument;
                        return result.get("id").equals(TestCars.BMW_530D_2013.getId())
                                && result.get("userId").equals(TestCars.BMW_530D_2013.getUserId());
                    }
                }));

        verify(carsController, times(1)).insert(insertCar);
        verifyNoMoreInteractions(carsController);
    }
}