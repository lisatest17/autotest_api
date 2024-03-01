package com.project.stepDefinitions;

import io.cucumber.java.ru.Когда;
import io.restassured.response.Response;
import requests.petRequests;

import static org.junit.Assert.assertEquals;

public class petStep {
    
    @Когда("получено животное с id {string} статус {int}")
    public void getPetByID(String arg0, int arg1) {
        Response response = new petRequests().getPet(arg0);
        assertEquals(arg1, response.getStatusCode());
    }
}
