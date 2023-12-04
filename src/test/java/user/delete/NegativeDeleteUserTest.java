package user.delete;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import petstore.swagger.requests.Requests;
import user.UserBaseTests;

import static org.apache.http.HttpStatus.SC_METHOD_NOT_ALLOWED;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static petstore.swagger.instances.endpoints.UserEndpoint.USER;
import static petstore.swagger.instances.endpoints.UserEndpoint.USER_STRICT;

public class NegativeDeleteUserTest extends UserBaseTests {

    @BeforeClass
    public void beforeDeleteNegativeTests() {
        Requests.post(USER, user);
        Requests.delete( USER_STRICT + user.getUsername());
    }

    @Test
    public static void deleteNotExistingUserByIdNegativeTest() {
        Response response = Requests.delete( USER_STRICT + user.getUsername());
        Assert.assertEquals(response.getStatusCode(), SC_NOT_FOUND, "Delete not existing user has done successfully");
    }

    @Test
    public static void sendDeleteRequestWithEmptyQueryTest() {
        Response response = Requests.delete(USER_STRICT);
        Assert.assertEquals(response.getStatusCode(), SC_METHOD_NOT_ALLOWED, "Empty query doesn't invoke an error");
    }
}
