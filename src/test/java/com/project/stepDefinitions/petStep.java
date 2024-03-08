package com.project.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.pet.Category;
import models.pet.Pet;
import models.pet.TagsItem;
import requests.petRequests;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class petStep {

    String petID;

    @When("post pet with parametrs that {int}")
    public void postPet(int statusCode, List<List<String>> dataTable) {
        Response response = new petRequests().postPet(
                Pet.builder()
                        .id(Integer.parseInt(dataTable.get(0).get(1)))
                        .category(Category.builder()
                                .id(Integer.parseInt(dataTable.get(1).get(1)))
                                .name(dataTable.get(2).get(1))
                                .build())
                        .name(dataTable.get(3).get(1))
                        .photoUrls(Collections.singletonList(dataTable.get(4).get(1)))
                        .tags(
                                Collections.singletonList(TagsItem.builder()
                                        .id(Integer.parseInt(dataTable.get(5).get(1)))
                                        .name(dataTable.get(6).get(1))
                                        .build())
                        )
                        .status(dataTable.get(7).get(1))
                        .build()
        );
        petID = response.jsonPath().get("id").toString();
        assertEquals(statusCode, response.getStatusCode());
    }

    @And("get pet that {int}")
    public void getPet(int statusCode) {
        Response response = new petRequests().getPet(petID);
        assertEquals(statusCode, response.getStatusCode());
    }

    @Then("delete pet that {int}")
    public void deletePet(int statusCode) {
        Response response = new petRequests().deletePet(petID);
        assertEquals(statusCode, response.getStatusCode());
    }
}
