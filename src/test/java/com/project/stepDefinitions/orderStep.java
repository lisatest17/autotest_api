package com.project.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.order.Order;
import requests.orderRequests;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class orderStep {

    String orderID;
    @When("create order status code {int}")
    public void postOrder(int statusCode, List<List<String>> dataTable) {
        Response response = new orderRequests().postOrder(
                Order.builder()
                        .id(Integer.parseInt(dataTable.get(0).get(1)))
                        .petId(Integer.parseInt(dataTable.get(1).get(1)))
                        .quantity(Integer.parseInt(dataTable.get(2).get(1)))
                        .shipDate(dataTable.get(3).get(1))
                        .status(dataTable.get(5).get(1))
                        .complete(Boolean.parseBoolean(dataTable.get(4).get(1)))
                        .build());
        orderID = response.jsonPath().get("id").toString();
        assertEquals(statusCode, response.getStatusCode());
    }

    @And("get the order status {int}")
    public void getOrder(int statusCode) {
        Response response = new orderRequests().getOrder(orderID);
        assertEquals(statusCode, response.getStatusCode());
    }

    @Then("delete the order status {int}")
    public void deleteOrder(int statusCode) {
        Response response = new orderRequests().deleteOrder(orderID);
        assertEquals(statusCode, response.getStatusCode());
    }
}
