package com.personalgarage.service.integration;

import com.personalgarage.service.BaseTest;
import com.personalgarage.service.controllers.CarsController;
import com.personalgarage.service.data.TestCars;
import com.personalgarage.service.dto.CarsDTO;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
    public void givenCarIdReturnsCarDTO() throws Exception {
        CarsDTO car = new CarsDTO();
        car.setId(TestCars.BMW_530D_2013.getId());
        when(carsController.get("1")).thenReturn(car);

        mockMvc.perform(get("/cars/{id}", TestCars.BMW_530D_2013.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", new ArgumentMatcher<String>() {
                    @Override
                    public boolean matches(Object argument) {
                        return TestCars.BMW_530D_2013.getId().equals((String) argument);
                    }
                }));

        verify(carsController, times(1)).get("1");
        verifyNoMoreInteractions(carsController);
    }

    @Test
    @WithMockUser
    public void givenCarDTOReturnsInsertedCarDTO() {
    }
}