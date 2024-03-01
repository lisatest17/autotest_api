package requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.pet.Pet;

import static config.ApiConfig.getRequestSpecification;
import static constant.urlConstants.PET_URL;
import static io.restassured.RestAssured.given;

public class petRequests {

    // запрос создания животного

    public Response postPet(Pet pet){
        Response response = given(getRequestSpecification())
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .post(PET_URL)
                .andReturn();
        return response;
    }

    // запрос обновления животного
    public Response putPet(Pet pet){
        Response response = given(getRequestSpecification())
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .put(PET_URL)
                .andReturn();
        return response;
    }

    // запрос получения животного
    public Response getPet(String petID){
        Response response = given(getRequestSpecification())
                .contentType(ContentType.JSON)
                .when()
                .get(PET_URL + petID)
                .andReturn();
        return response;
    }

    // запрос удаления животного
    public Response deletePet(String petID){
        Response response = given(getRequestSpecification())
                .contentType(ContentType.JSON)
                .when()
                .delete(PET_URL + petID)
                .andReturn();
        return response;
    }
}
