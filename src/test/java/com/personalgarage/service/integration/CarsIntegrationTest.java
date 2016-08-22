package com.personalgarage.service.integration;

import com.personalgarage.service.BaseTest;
import com.personalgarage.service.controllers.interfaces.ICarsController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CarsIntegrationTest extends BaseTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ICarsController carsController;

    @Test
    public void givenEmptyObjectReturnBadRequest() {

    }
}