package com.personalgarage.service.base.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ServiceTaskCreator {

    private final ApplicationContext applicationContext;

    @Autowired
    public ServiceTaskCreator(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public  <T> T createTask(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }
}