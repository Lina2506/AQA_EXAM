package org.base.helpers;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.*;
import io.restassured.http.ContentType;
import io.restassured.specification.*;


public class SpecificationsRestAssured {
    public static final String BASE_URL = "http://185.69.152.209/carsAPI/v2";
    public static RequestSpecification requestSpecification(String url){
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL+url)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .build();
    }
    public static ResponseSpecification responseSpecification(int statusCode){
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .build();
    }
    public static void getSpecifications(RequestSpecification requestSpecification, ResponseSpecification responseSpecification){
        RestAssured.requestSpecification=requestSpecification;
        RestAssured.responseSpecification=responseSpecification;
    }
}
