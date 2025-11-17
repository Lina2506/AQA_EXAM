package org.base.helpers;

import org.base.pojos.authMe.AuthMeResponse;
import org.base.pojos.authUser.*;
import org.base.pojos.createUser.*;

import static io.restassured.RestAssured.given;
import static org.base.helpers.SpecificationsRestAssured.*;

public class ApiUserHelper {

//_____________CREATE USER____________________
    public static CreateUserResponse createUser(String username, String password) {
        getSpecifications(requestSpecification(ApiEndpoints.USERS),responseSpecification(201));

        CreateUserRequest createUserRequest = new CreateUserRequest();

        createUserRequest.setUsername(username);
        createUserRequest.setPassword(password);

        return given()
                        .body(createUserRequest)
                        .when()
                        .post()
                        .then()
                        .log().all()
                        .extract()
                        .as(CreateUserResponse.class);
    }
//_______________AUTH USER__________________
    public static AuthResponse authenticateUser(String username, String password) {
        getSpecifications(requestSpecification(ApiEndpoints.AUTH), responseSpecification(200));

        AuthRequest authRequest = new AuthRequest();
        authRequest.setUsername(username);
        authRequest.setPassword(password);

        return given()
                        .body(authRequest)
                        .when()
                        .post()
                        .then()
                        .log().all()
                        .extract()
                        .as(AuthResponse.class);
    }
//_____________________GET USER BY TOKEN________________
    public static AuthMeResponse getUser(String accessToken){
        getSpecifications(requestSpecification(ApiEndpoints.AUTH_ME),responseSpecification(200));

        return given()
                .header("Authorization", "Bearer "+ accessToken)
                .when()
                .get()
                .then()
                .extract()
                .as(AuthMeResponse.class);
    }
}
