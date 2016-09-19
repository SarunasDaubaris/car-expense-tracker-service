package com.personalgarage.service.domain.integration;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CarsIntegrationTest.class,
        TransactionsIntegrationTest.class
})
public class DomainIntegrationTestSuite {
}