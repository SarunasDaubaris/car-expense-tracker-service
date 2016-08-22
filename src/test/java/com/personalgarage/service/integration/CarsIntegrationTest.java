package com.personalgarage.service.integration;

import com.personalgarage.service.integration.base.BaseRestIntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

public class CarsIntegrationTest extends BaseRestIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void givenEmptyObjectReturnBadRequest() {

    }
}