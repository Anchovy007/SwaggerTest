package user.delete;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import petstore.swagger.requests.Requests;
import user.UserBaseTests;

import static org.apache.http.HttpStatus.SC_OK;
import static petstore.swagger.instances.endpoints.UserEndpoint.USER;
import static petstore.swagger.instances.endpoints.UserEndpoint.USER_STRICT;

public class PositiveDeleteUserTest extends UserBaseTests {

    @BeforeClass
    public void beforeCreateUserTests() {
        Requests.post(USER, user);
    }

    @Test
    public static void deleteUserByIdPositiveTest() {
        Response response = Requests.delete( USER_STRICT + user.getUsername());
        Assert.assertEquals(response.getStatusCode(), SC_OK, "Couldn't delete existing user by id");
    }

}
