package petstore.swagger.requests;


import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;

import static petstore.swagger.instances.urls.BaseUrls.BASE_URL;

public class Requests {
    public static Response get(String url) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .header("Content-type", "application/json")
                .when()
                .get(url)
                .then()
                .log().all()
                .extract().response();
    }

    public static Response post(String url, Object pet) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .header("Content-type", "application/json")
                .body(pet)
                .when()
                .post(url)
                .then()
                .log().all()
                .extract().response();
    }

    public static Response post(String url, String image) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .header("Content-type", "multipart/form-data")
                .multiPart(new File(image))
                .when()
                .post(url)
                .then()
                .log().all()
                .extract().response();
    }

    public static Response put(String url, Object pet) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .header("Content-type", "application/json")
                .body(pet)
                .when()
                .put(url)
                .then()
                .log().all()
                .extract().response();
    }

    public static Response delete(String url) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .header("Content-type", "application/json")
                .when()
                .delete(url)
                .then()
                .log().all()
                .extract().response();
    }
}