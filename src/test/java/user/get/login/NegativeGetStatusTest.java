package user.get.login;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import petstore.swagger.requests.Requests;
import user.UserBaseTests;

import static org.apache.http.HttpStatus.*;
import static petstore.swagger.instances.endpoints.UserEndpoint.*;

public class NegativeGetStatusTest extends UserBaseTests {

    @BeforeClass
    public void beforeCreateUserTests() {
        Requests.post(USER, user);
    }

    @Test
    public void getUserLoginIncorrectPassword() {
        Response response = Requests.getUserLogin(USER_LOGIN, user.getUsername(), "AAA");
        Assert.assertEquals(response.getStatusCode(), SC_BAD_REQUEST, "The user has gained access");
    }

    @Test
    public void getUserLoginIncorrectUsername() {
        Response response = Requests.getUserLogin(USER_LOGIN, "AAA", user.getPassword());
        Assert.assertEquals(response.getStatusCode(), SC_BAD_REQUEST, "The user has gained access");
    }

    @Test
    public void getUserLoginIncorrectUsernameAndPassword() {
        Response response = Requests.getUserLogin(USER_LOGIN,"AAA", "AAA");
        Assert.assertEquals(response.getStatusCode(), SC_BAD_REQUEST, "The user has gained access");
    }

    @Test
    public void getUserNotExist() {
        Requests.delete( USER_STRICT + user.getUsername());
        Response response = Requests.getUserLogin(USER_LOGIN, user.getUsername(), user.getPassword());
        Assert.assertEquals(response.getStatusCode(), SC_NOT_FOUND, "Delete not existing user has done successfully");
    }
}
