package petstore.swagger.requests;


import io.qameta.allure.Step;
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

    public static Response getUserLogin(String url, String username, String password) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .header("Content-type", "application/json")
                .queryParam("username", username)
                .queryParam("password", password)
                .get(url)
                .then()
                .log().all()
                .extract().response();
    }

    public static Response getUserLogout(String url) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .header("Content-type", "application/json")
                .get(url)
                .then()
                .log().all()
                .extract().response();
    }

    public static Response post(String url, Object model) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .header("Content-type", "application/json")
                .body(model)
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

    public static Response post(String url, Object... model) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .header("Content-type", "application/json")
                .body(model)
                .when()
                .post(url)
                .then()
                .log().all()
                .extract().response();
    }

    public static Response put(String url, Object model) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .header("Content-type", "application/json")
                .body(model)
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