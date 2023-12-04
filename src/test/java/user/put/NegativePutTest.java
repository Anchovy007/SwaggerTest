package user.put;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import petstore.swagger.requests.Requests;
import user.UserBaseTests;

import static org.apache.http.HttpStatus.SC_METHOD_NOT_ALLOWED;
import static petstore.swagger.instances.endpoints.UserEndpoint.USER;
import static petstore.swagger.instances.endpoints.UserEndpoint.USER_STRICT;

public class NegativePutTest extends UserBaseTests {
    @BeforeClass
    public void beforeGetByIdTests() {
        Requests.post(USER, user);
    }

    @Test
    public void putByUsernameNegativeNonexistentUsername() {
        Requests.delete( USER_STRICT + user.getUsername());
        Response response = Requests.put(USER_STRICT, user);
        Assert.assertEquals(response.getStatusCode(), SC_METHOD_NOT_ALLOWED, "User found");
    }
}
