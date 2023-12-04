package user.get.logout;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import petstore.swagger.requests.Requests;
import user.UserBaseTests;

import static org.apache.http.HttpStatus.SC_OK;
import static petstore.swagger.instances.endpoints.UserEndpoint.USER;
import static petstore.swagger.instances.endpoints.UserEndpoint.USER_LOGOUT;

public class PositiveGetStatusTest extends UserBaseTests {
    @BeforeClass
    public void beforeGetByIdTests() {
        Requests.post(USER, user);
    }
    @Test
    public void testGetUserLogout() {
        Response response = Requests.getUserLogout(USER_LOGOUT);
        Assert.assertEquals(response.getStatusCode(), (SC_OK));
    }
}
