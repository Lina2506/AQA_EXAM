package api;

import org.base.helpers.ApiUserHelper;
import org.base.pojos.authMe.AuthMeResponse;
import org.base.pojos.authUser.AuthResponse;
import org.base.pojos.createUser.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

public class ApiSystemTest {

    @Test(description = "Verify that user can be created, authenticated and retrieved by token")
    public void createAndGetUser() {
//___________________CreatedUserTest_______________________
        String username="sdcjTTHH";
        String password="Aqa12345!";

        CreateUserResponse createUser = ApiUserHelper.createUser(username,password);

        Assert.assertNotNull(createUser);
        Assert.assertTrue(createUser.getCreated().isBefore(LocalDateTime.now()));
        Assert.assertEquals(username, createUser.getUsername());

//_______________AuthenticateUserTest_______________________
        AuthResponse authResponse= ApiUserHelper.authenticateUser(username,password);

        Assert.assertNotNull(authResponse);
        Assert.assertNotNull(authResponse.getAccess());
        Assert.assertNotNull(authResponse.getRefresh());

//______________SuccessfullyAuthenticated_____________________

        AuthMeResponse getUserResponse=ApiUserHelper.getUser(authResponse.getAccess());

        Assert.assertNotNull(getUserResponse);
        Assert.assertEquals(username, getUserResponse.getUsername());

    }
}
