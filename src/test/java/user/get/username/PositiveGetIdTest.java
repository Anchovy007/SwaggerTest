package user.get.username;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import petstore.swagger.requests.Requests;
import petstore.validator.JsonValidator;
import user.UserBaseTests;

import static org.apache.http.HttpStatus.SC_OK;
import static petstore.swagger.instances.endpoints.UserEndpoint.USER;
import static petstore.swagger.instances.endpoints.UserEndpoint.USER_STRICT;
import static petstore.validator.ValidationTemplatePaths.PATH_TO_USER_TEMPLATE;

public class PositiveGetIdTest extends UserBaseTests {

    @BeforeClass
    public void beforeGetByIdTests() {
        Requests.post(USER, user);
    }

    @Test
    public static void getPetByIdPositive() {
        Response response = Requests.get(USER_STRICT + user.getUsername());
        Assert.assertEquals(response.getStatusCode(), SC_OK, "Couldn't get user by username");
        JsonValidator.validateObject(response, PATH_TO_USER_TEMPLATE);
    }
}
