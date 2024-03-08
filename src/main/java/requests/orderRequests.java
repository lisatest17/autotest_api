package requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.order.Order;

import static config.ApiConfig.getRequestSpecification;
import static constant.urlConstants.STORE_URL;
import static io.restassured.RestAssured.given;

public class orderRequests {
    public Response postOrder(Order order){
        Response response = given(getRequestSpecification())
                .contentType(ContentType.JSON)
                .body(order)
                .when()
                .post(STORE_URL)
                .andReturn();
        return response;
    }

    public Response getOrder(String orderID){
        Response response = given(getRequestSpecification())
                .contentType(ContentType.JSON)
                .when()
                .get(STORE_URL + orderID)
                .andReturn();
        return response;
    }

    public Response deleteOrder(String orderID){
        Response response = given(getRequestSpecification())
                .contentType(ContentType.JSON)
                .body(orderID)
                .when()
                .delete(STORE_URL + orderID)
                .andReturn();
        return response;
    }
}
