package api;

import org.base.helpers.ApiUserHelper;
import org.base.helpers.TestDataForAPITests;
import org.base.pojos.authMe.AuthMeResponse;
import org.base.pojos.authUser.AuthResponse;
import org.base.pojos.createUser.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

public class ApiSystemTest {

    private static String username;
    private static String password;
    private static String accessToken;

    @Test(groups = "api", priority = 1, description = "Verify that user can be created")
    public void createUserTest() {
        username = TestDataForAPITests.generateUsername();
        password = TestDataForAPITests.DEFAULT_PASSWORD;

        CreateUserResponse createUser = ApiUserHelper.createUser(username, password);

        Assert.assertNotNull(createUser, "Create user response should not be null");
        Assert.assertTrue(createUser.getCreated().isBefore(LocalDateTime.now()),
                "Created time should be before current time");
        Assert.assertEquals(username, createUser.getUsername(), "Username should match the created username in response");
    }

    @Test(groups = "api", priority = 2, dependsOnMethods = "createUserTest", description = "Verify that user can be authenticated")
            public void authenticateUserTest() {

        if (username==null){
            username = TestDataForAPITests.generateUsername();
            password = TestDataForAPITests.DEFAULT_PASSWORD;
            ApiUserHelper.createUser(username, password);
        }

        AuthResponse authResponse = ApiUserHelper.authenticateUser(username, password);

        Assert.assertNotNull(authResponse, "Auth response should not be null");
        Assert.assertNotNull(authResponse.getAccess(), "Access token should not be null");
        Assert.assertNotNull(authResponse.getRefresh(), "Refresh token should not be null");

        accessToken = authResponse.getAccess();
    }
    @Test(groups = "api", priority = 3, dependsOnMethods = "authenticateUserTest", description = "Verify that authenticated user can be retrieved by token")
            public void getUserByTokenTest() {

        if (username==null || accessToken==null){
            username = TestDataForAPITests.generateUsername();
            password = TestDataForAPITests.DEFAULT_PASSWORD;
            ApiUserHelper.createUser(username, password);
            AuthResponse authResponse = ApiUserHelper.authenticateUser(username, password);
            accessToken = authResponse.getAccess();
        }

        AuthMeResponse getUserResponse=ApiUserHelper.getUser(accessToken);

        Assert.assertNotNull(getUserResponse,
                "Get user response should not be null");
        Assert.assertEquals(username, getUserResponse.getUsername(),
                "Username should match the authenticated user");
    }
}
