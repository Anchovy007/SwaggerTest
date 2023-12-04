package user.get.login;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import petstore.swagger.requests.Requests;
import user.UserBaseTests;

import static org.apache.http.HttpStatus.SC_OK;
import static petstore.swagger.instances.endpoints.UserEndpoint.USER;
import static petstore.swagger.instances.endpoints.UserEndpoint.USER_LOGIN;

public class PositiveGetStatusTest extends UserBaseTests {

    @BeforeClass
    public void beforeCreateUserTests() {
        Requests.post(USER, user);
    }

    @Test
    public void getUserLogin() {
        Response response = Requests.getUserLogin(USER_LOGIN, user.getUsername(), user.getPassword());
        Assert.assertEquals(response.getStatusCode(), SC_OK, "Invalid password, username, or user does not exist");
    }
}
